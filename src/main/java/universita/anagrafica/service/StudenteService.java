package universita.anagrafica.service;

import org.springframework.stereotype.Service;
import universita.anagrafica.client.EsamiClient;
import universita.anagrafica.client.extClient.EsameObbligatorio;
import universita.anagrafica.client.extClient.LibrettoVuoto;
import universita.anagrafica.domain.Corso;
import universita.anagrafica.domain.Studente;
import universita.anagrafica.dto.StudenteDTO;
import universita.anagrafica.kafka.Producer;
import universita.anagrafica.mapper.StudenteMapper;
import universita.anagrafica.repository.CorsoDiLaureaRepository;
import universita.anagrafica.repository.CorsoRepository;
import universita.anagrafica.repository.StudenteRepository;

import java.time.LocalDate;
import java.util.ArrayList;
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

    public StudenteService(StudenteRepository studenteRepository, Producer producer, StudenteMapper studenteMapper, EsamiClient esamiClient, CorsoRepository corsoRepository, CorsoDiLaureaRepository corsoDiLaureaRepository) {
        this.studenteRepository = studenteRepository;
        this.producer = producer;
        this.studenteMapper = studenteMapper;
        this.esamiClient = esamiClient;
        this.corsoRepository = corsoRepository;
        this.corsoDiLaureaRepository = corsoDiLaureaRepository;
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

    public void attivaStudente(Integer matricola, Integer corsoDiLaurea) {
        studenteRepository.findById(matricola).ifPresent(s-> {
            if(s.getAttivo() == null || s.getAttivo() == false){
                LibrettoVuoto librettoVuoto = inizializza(matricola, corsoDiLaurea);
                try{
                    String result = esamiClient.caricaLibretto(librettoVuoto).getBody();
                }catch(Exception e){
                    System.out.println("Lanciata eccezione: " + e.getClass());
                    librettoVuoto.setCodice("attivaStudente");
                    producer.sendMessaggio(librettoVuoto);
                }
                s.setAttivo(true);
                s.setCorsoDiLaurea(corsoDiLaureaRepository.findById(corsoDiLaurea).get());
                studenteRepository.save(s);
            }
        });
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
}
