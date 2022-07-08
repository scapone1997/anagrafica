package universita.anagrafica.service;

import org.springframework.stereotype.Service;
import universita.anagrafica.dto.CorsoDTO;
import universita.anagrafica.mapper.CorsoMapper;
import universita.anagrafica.repository.CorsoRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CorsoService {

    private final CorsoRepository corsoRepository;
    private final CorsoMapper corsoMapper;

    public CorsoService(CorsoRepository corsoRepository, CorsoMapper corsoMapper) {
        this.corsoRepository = corsoRepository;
        this.corsoMapper = corsoMapper;
    }

    public List<CorsoDTO> listOfCorsi() {
        return corsoRepository
                .findAll()
                .stream()
                .map(corso -> corsoMapper.corsoToCorsoDTO(corso))
                .collect(Collectors.toList());
    }

    public void saveCorso(CorsoDTO corsoDTO) {
        corsoRepository.save(corsoMapper.corsoDTOToCorso(corsoDTO));
    }
}
