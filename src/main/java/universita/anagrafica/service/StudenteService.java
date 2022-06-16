package universita.anagrafica.service;

import org.springframework.stereotype.Service;
import universita.anagrafica.dto.StudenteDTO;
import universita.anagrafica.repository.StudenteRepository;

@Service
public class StudenteService {
    private final StudenteRepository studenteRepository;

    public StudenteService(StudenteRepository studenteRepository) {
        this.studenteRepository = studenteRepository;
    }

    public StudenteDTO saveStudente(StudenteDTO studenteDTO){
        return new StudenteDTO();
    }
}
