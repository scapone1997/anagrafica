package universita.anagrafica.service;

import org.springframework.stereotype.Service;
import universita.anagrafica.repository.ProfessoreRepository;

@Service
public class ProfessoreService {

    private final ProfessoreRepository professoreRepository;

    public ProfessoreService(ProfessoreRepository professoreRepository) {
        this.professoreRepository = professoreRepository;
    }
}
