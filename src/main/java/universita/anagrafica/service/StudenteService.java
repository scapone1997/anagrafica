package universita.anagrafica.service;

import org.springframework.stereotype.Service;
import universita.anagrafica.domain.Studente;
import universita.anagrafica.dto.StudenteDTO;
import universita.anagrafica.kafka.Producer;
import universita.anagrafica.mapper.StudenteMapper;
import universita.anagrafica.repository.StudenteRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudenteService {
    private final StudenteRepository studenteRepository;

    private final Producer producer;

    private final StudenteMapper studenteMapper;

    public StudenteService(StudenteRepository studenteRepository, Producer producer, StudenteMapper studenteMapper) {
        this.studenteRepository = studenteRepository;
        this.producer = producer;
        this.studenteMapper = studenteMapper;
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

    public void deleteStudente(Integer matricola) {
        studenteRepository.deleteById(matricola);
    }

    public void attivaStudente(Integer matricola) {
        studenteRepository.findById(matricola).ifPresent(s-> {
            if(!s.getAttivo())
                s.setAttivo(true);
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
}
