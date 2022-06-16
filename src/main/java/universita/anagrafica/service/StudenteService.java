package universita.anagrafica.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import universita.anagrafica.dto.StudenteDTO;
import universita.anagrafica.mapper.StudenteMapper;
import universita.anagrafica.repository.StudenteRepository;

@Service
public class StudenteService {
    private final StudenteRepository studenteRepository;

    private final StudenteMapper studenteMapper;

    public StudenteService(StudenteRepository studenteRepository, StudenteMapper studenteMapper) {
        this.studenteRepository = studenteRepository;
        this.studenteMapper = studenteMapper;
    }

    public void saveStudente(StudenteDTO studenteDTO) {
        studenteRepository.save(studenteMapper.studenteDTOToStudente(studenteDTO));
    }
}
