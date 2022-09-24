package universita.anagrafica.service;

import org.springframework.stereotype.Service;
import universita.anagrafica.client.EsamiClient;
import universita.anagrafica.client.extClient.ControlloCorsoStudente;
import universita.anagrafica.client.extClient.EsameObbligatorio;
import universita.anagrafica.client.extClient.LibrettoVuoto;
import universita.anagrafica.client.extClient.Prenotazione;
import universita.anagrafica.domain.Corso;
import universita.anagrafica.domain.EdizioneCorso;
import universita.anagrafica.domain.Studente;
import universita.anagrafica.dto.StudenteDTO;
import universita.anagrafica.kafka.Producer;
import universita.anagrafica.mapper.StudenteMapper;
import universita.anagrafica.repository.CorsoDiLaureaRepository;
import universita.anagrafica.repository.CorsoRepository;
import universita.anagrafica.repository.EdizioneCorsoRepository;
import universita.anagrafica.repository.StudenteRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudenteService {
    private final StudenteRepository studenteRepository;

    private final Producer producer;

    private final StudenteMapper studenteMapper;

    private final EsamiClient esamiClient;

    private final CorsoRepository corsoRepository;

    private final CorsoDiLaureaRepository corsoDiLaureaRepository;

    private final EdizioneCorsoRepository edizioneCorsoRepository;

    public StudenteService(StudenteRepository studenteRepository, Producer producer, StudenteMapper studenteMapper, EsamiClient esamiClient, CorsoRepository corsoRepository, CorsoDiLaureaRepository corsoDiLaureaRepository, EdizioneCorsoRepository edizioneCorsoRepository) {
        this.studenteRepository = studenteRepository;
        this.producer = producer;
        this.studenteMapper = studenteMapper;
        this.esamiClient = esamiClient;
        this.corsoRepository = corsoRepository;
        this.corsoDiLaureaRepository = corsoDiLaureaRepository;
        this.edizioneCorsoRepository = edizioneCorsoRepository;
    }

    public void saveStudente(StudenteDTO studenteDTO) {
        //producer.sendStudente(studenteMapper.toEntity(studenteDTO));
        studenteRepository.save(studenteMapper.toEntity(studenteDTO));
    }

    public List<StudenteDTO> listOfStudenti() {
        return studenteRepository
                .findAll()
                .stream()
                .map(studente -> studenteMapper.toDto(studente))
                .collect(Collectors.toList());
    }

    public List<StudenteDTO> listOfStudentiAfterMatricola(Integer matricola){
        return studenteRepository
                .findStudentAfterMatricola(matricola)
                .stream()
                .map(studente -> studenteMapper.toDto(studente))
                .collect(Collectors.toList());
    }

    public List<StudenteDTO> listOfStudentiAfterDataNascita(LocalDate date){
        return studenteRepository
                .findStudenteAfterDataNascita(date)
                .stream()
                .map(studente -> studenteMapper.toDto(studente))
                .collect(Collectors.toList());
    }
    public void updateStudente(StudenteDTO studenteDTO, Integer matricola) {
        if(studenteDTO.getMatricola().equals(matricola)){
            Optional<Studente> studenteDB = studenteRepository.findById(matricola);
            if(studenteDB.isPresent()){
                studenteRepository.save(studenteMapper.toEntity(studenteDTO));
            }
        }else throw new RuntimeException("Operazione non consentita.");
    }

    public void deleteStudente(Integer matricola) throws Exception{
        studenteRepository.findById(matricola).ifPresent(s->{
            if(s.getAttivo() != null){
                try {
                    String result = esamiClient.eliminaLibretto(matricola).getBody();
                    if(result.equals("ok")){
                        studenteRepository.deleteById(matricola);
                    }
                } catch (Exception e) {
                    throw new RuntimeException("Errore nel contattare esami: " + e.getClass());
                }
            }
        });
    }

    public void attivaStudente(Integer matricola, Integer corsoDiLaurea) throws Exception {
        studenteRepository.findById(matricola).ifPresentOrElse(s-> {
            if(s.getAttivo() == null || s.getAttivo() == false){
                LibrettoVuoto librettoVuoto = inizializza(matricola, corsoDiLaurea);
                try{
                    String result = esamiClient.caricaLibretto(librettoVuoto).getBody();
                }catch(Exception e){
                    System.out.println("Lanciata eccezione: " + e.getClass());
                    librettoVuoto.setCodice("attivaStudente");
                    producer.sendMessaggio(librettoVuoto, "studenti");
                }
                s.setAttivo(true);
                s.setCorsoDiLaurea(corsoDiLaureaRepository.findById(corsoDiLaurea).get());
                studenteRepository.save(s);
            }
        }, ()->{throw new RuntimeException("Studente non presente nel DB.");});
    }

    public void laureaStudente(Integer matricola) {
        studenteRepository.findById(matricola).ifPresent(s-> {
            if(!s.getLaureato()){
                s.setLaureato(true);
                s.setAttivo(false);
            }
        });
    }

    private LibrettoVuoto inizializza(Integer matricola, Integer corsoDiLaurea) {
        LibrettoVuoto librettoVuoto = new LibrettoVuoto();
        librettoVuoto.setMatricola(matricola);
        List<EsameObbligatorio> listEsami = new ArrayList<>();
        List<Corso> corsoList = corsoRepository
                .findByCorsoDiLaureaAndObbligatorio(corsoDiLaureaRepository.findById(corsoDiLaurea).get(), true);
        corsoList.forEach(c->{
            EsameObbligatorio esameObbligatorio = new EsameObbligatorio();
            esameObbligatorio.setId(c.getId());
            esameObbligatorio.setNome(c.getNome());
            listEsami.add(esameObbligatorio);
        });
        librettoVuoto.setEsami(listEsami);
        return librettoVuoto;
    }

    public ControlloCorsoStudente prenotaStudente(Integer matricola, Integer edizioneCorso, Date dataAppello) throws Exception{
        ControlloCorsoStudente controlloCorsoStudente = new ControlloCorsoStudente();
        Prenotazione prenotazione = new Prenotazione();
        controlloCorsoStudente.setStudente(matricola);
        EdizioneCorso edizioneCorsoDB = edizioneCorsoRepository.findById(edizioneCorso).get();
        controlloCorsoStudente.setCorso(edizioneCorsoDB.getCorso().getId());
        Boolean nonEsiste = true;
        try {
            nonEsiste = esamiClient.isCorsoNonVerbalizzato(controlloCorsoStudente).getBody();
        } catch (Exception e) {
            System.out.println("Non riesco a contattare Esami.");
        }
        if (nonEsiste) {
            prenotazione.setStudente(matricola);
            prenotazione.setEdizioneCorso(edizioneCorso);
            prenotazione.setDataAppello(dataAppello);
            prenotazione.setNome(corsoRepository.findById(edizioneCorsoDB.getCorso().getId()).get().getNome());
            prenotazione.setCodice("prenotaStudente");
            prenotazione.setCorso(edizioneCorsoDB.getCorso().getId());
            try {
                esamiClient.prenotaStudente(prenotazione);
                System.out.println("Messaggio" + prenotazione + " inviato a Esami.");
            } catch (Exception e) {
                System.out.println("Non riesco a contattare Esami.");
                try {
                    producer.sendMessaggio(prenotazione, "prenotazioni");
                } catch (Exception ex) {
                    System.out.println("Non riesco a scrivere su Kafka.");
                    throw new RuntimeException(ex);
                }
            }
        }
        return controlloCorsoStudente;
    }
}
