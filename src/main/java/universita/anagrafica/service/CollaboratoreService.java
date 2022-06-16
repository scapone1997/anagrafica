package universita.anagrafica.service;

import org.springframework.stereotype.Service;
import universita.anagrafica.repository.CollaboratoreRepository;

@Service
public class CollaboratoreService {

    private final CollaboratoreRepository collaboratoreRepository;

    public CollaboratoreService(CollaboratoreRepository collaboratoreRepository) {
        this.collaboratoreRepository = collaboratoreRepository;
    }
}
