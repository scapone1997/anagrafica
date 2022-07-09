package universita.anagrafica.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import universita.anagrafica.domain.Corso;
import universita.anagrafica.domain.CorsoDiLaurea;
import universita.anagrafica.domain.Professore;
import universita.anagrafica.dto.CorsoDTO;
import universita.anagrafica.mapper.CorsoMapper;
import universita.anagrafica.repository.CorsoDiLaureaRepository;
import universita.anagrafica.repository.CorsoRepository;
import universita.anagrafica.repository.ProfessoreRepository;

import java.util.List;
import java.util.Optional;
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
        Optional<Professore> professore = professoreRepository.findById(corsoDTO.getProfessoreMatricola());
        Optional<CorsoDiLaurea> corsoDiLaurea = corsoDiLaureaRepository.findById(corsoDTO.getCorsoDiLaurea());
        if(professore.isPresent() && corsoDiLaurea.isPresent()){
            corso.setProfessore(professore.get());
            corso.setCorsoDiLaurea(corsoDiLaurea.get());
            corsoRepository.save(corso);
        }
        else
            throw new RuntimeException("Campo non esistente");
    }
}
