package universita.anagrafica.service;

import org.springframework.stereotype.Service;
import universita.anagrafica.dto.ProfessoreDTO;
import universita.anagrafica.mapper.ProfessoreMapper;
import universita.anagrafica.repository.ProfessoreRepository;

@Service
public class ProfessoreService {

    private final ProfessoreRepository professoreRepository;

    private final ProfessoreMapper professoreMapper;

    public ProfessoreService(ProfessoreRepository professoreRepository, ProfessoreMapper professoreMapper) {
        this.professoreRepository = professoreRepository;
        this.professoreMapper = professoreMapper;
    }

    public void saveProfessore(ProfessoreDTO professoreDTO) {
        professoreRepository.save(professoreMapper.professoreDTOToProfessore(professoreDTO));
    }
}
