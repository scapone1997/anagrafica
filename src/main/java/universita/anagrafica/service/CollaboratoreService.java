package universita.anagrafica.service;

import org.springframework.stereotype.Service;
import universita.anagrafica.dto.CollaboratoreDTO;
import universita.anagrafica.mapper.CollaboratoreMapper;
import universita.anagrafica.repository.CollaboratoreRepository;

@Service
public class CollaboratoreService {

    private final CollaboratoreRepository collaboratoreRepository;

    private final CollaboratoreMapper collaboratoreMapper;

    public CollaboratoreService(CollaboratoreRepository collaboratoreRepository, CollaboratoreMapper collaboratoreMapper) {
        this.collaboratoreRepository = collaboratoreRepository;
        this.collaboratoreMapper = collaboratoreMapper;
    }

    public void saveCollaboratore(CollaboratoreDTO collaboratoreDTO) {
        collaboratoreRepository.save(collaboratoreMapper.collaboratoreDTOToCollaboratore(collaboratoreDTO));
    }
}
