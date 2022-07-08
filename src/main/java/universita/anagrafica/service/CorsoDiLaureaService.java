package universita.anagrafica.service;

import org.springframework.stereotype.Service;
import universita.anagrafica.dto.CorsoDiLaureaDTO;
import universita.anagrafica.mapper.CorsoDiLaureaMapper;
import universita.anagrafica.repository.CorsoDiLaureaRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CorsoDiLaureaService {

    private final CorsoDiLaureaRepository corsoDiLaureaRepository;

    private final CorsoDiLaureaMapper corsoDiLaureaMapper;

    public CorsoDiLaureaService(CorsoDiLaureaRepository corsoDiLaureaRepository, CorsoDiLaureaMapper corsoDiLaureaMapper) {
        this.corsoDiLaureaRepository = corsoDiLaureaRepository;
        this.corsoDiLaureaMapper = corsoDiLaureaMapper;
    }

    public List<CorsoDiLaureaDTO> listOfCorsiDiLaurea() {
        return corsoDiLaureaRepository
                .findAll()
                .stream()
                .map(corsoDiLaurea -> corsoDiLaureaMapper.corsoDiLaureaToCorsoDiLaureaDTO(corsoDiLaurea))
                .collect(Collectors.toList());
    }

    public void saveCorsoDiLaurea(CorsoDiLaureaDTO corsoDiLaureaDTO) {
        corsoDiLaureaRepository.save(corsoDiLaureaMapper.corsoDiLaureaDTOToCorsoDiLaurea(corsoDiLaureaDTO));
    }
}
