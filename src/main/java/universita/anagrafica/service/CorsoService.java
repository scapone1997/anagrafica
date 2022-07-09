package universita.anagrafica.service;

import org.springframework.stereotype.Service;
import universita.anagrafica.mapper.domain.Corso;
import universita.anagrafica.dto.CorsoDTO;
import universita.anagrafica.mapper.CorsoMapper;
import universita.anagrafica.repository.CorsoDiLaureaRepository;
import universita.anagrafica.repository.CorsoRepository;
import universita.anagrafica.repository.ProfessoreRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CorsoService {

    private final CorsoRepository corsoRepository;

    private final ProfessoreRepository professoreRepository;
    private final CorsoMapper corsoMapper;

    private final CorsoDiLaureaRepository corsoDiLaureaRepository;

    public CorsoService(CorsoRepository corsoRepository, ProfessoreRepository professoreRepository, CorsoMapper corsoMapper, CorsoDiLaureaRepository corsoDiLaureaRepository) {
        this.corsoRepository = corsoRepository;
        this.professoreRepository = professoreRepository;
        this.corsoMapper = corsoMapper;
        this.corsoDiLaureaRepository = corsoDiLaureaRepository;
    }

    public List<CorsoDTO> listOfCorsi() {
        return corsoRepository
                .findAll()
                .stream()
                .map(corso -> corsoMapper.toDto(corso))
                .collect(Collectors.toList());
    }

    public void saveCorso(CorsoDTO corsoDTO) {
        Corso corso = corsoMapper.toEntity(corsoDTO);
        corsoRepository.save(corso);
    }
}
