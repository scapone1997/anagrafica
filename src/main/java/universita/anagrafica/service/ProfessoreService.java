package universita.anagrafica.service;

import org.springframework.stereotype.Service;
import universita.anagrafica.dto.ProfessoreDTO;
import universita.anagrafica.mapper.ProfessoreMapper;
import universita.anagrafica.repository.ProfessoreRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProfessoreService {

    private final ProfessoreRepository professoreRepository;

    private final ProfessoreMapper professoreMapper;

    public ProfessoreService(ProfessoreRepository professoreRepository, ProfessoreMapper professoreMapper) {
        this.professoreRepository = professoreRepository;
        this.professoreMapper = professoreMapper;
    }

    public void saveProfessore(ProfessoreDTO professoreDTO) {
        professoreRepository.save(professoreMapper.toEntity(professoreDTO));
    }

    public List<ProfessoreDTO> listOfProfessori() {
        return professoreRepository
                .findAll()
                .stream()
                .map(professore -> professoreMapper.toDto(professore))
                .collect(Collectors.toList());
    }
}
