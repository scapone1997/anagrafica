package universita.anagrafica.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import universita.anagrafica.dto.StudenteDTO;
import universita.anagrafica.kafka.Producer;
import universita.anagrafica.mapper.StudenteMapper;
import universita.anagrafica.repository.StudenteRepository;

import java.time.LocalDate;
import java.util.List;
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
        producer.sendStudente(studenteMapper.studenteDTOToStudente(studenteDTO));
        studenteRepository.save(studenteMapper.studenteDTOToStudente(studenteDTO));
    }

    public List<StudenteDTO> listOfStudenti() {
        return studenteRepository
                .findAll()
                .stream()
                .map(studente -> studenteMapper.studenteToStudenteDTO(studente))
                .collect(Collectors.toList());
    }

    public List<StudenteDTO> listOfStudentiAfterMatricola(Integer matricola){
        return studenteRepository
                .findStudentAfterMatricola(matricola)
                .stream()
                .map(studente -> studenteMapper.studenteToStudenteDTO(studente))
                .collect(Collectors.toList());
    }

    public List<StudenteDTO> listOfStudentiAfterDataNascita(LocalDate date){
        return studenteRepository
                .findStudenteAfterDataNascita(date)
                .stream()
                .map(studente -> studenteMapper.studenteToStudenteDTO(studente))
                .collect(Collectors.toList());
    }
}
