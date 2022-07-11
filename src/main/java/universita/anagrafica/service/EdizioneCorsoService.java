package universita.anagrafica.service;

import org.springframework.stereotype.Service;
import universita.anagrafica.domain.EdizioneCorso;
import universita.anagrafica.dto.CorsoDTO;
import universita.anagrafica.dto.EdizioneCorsoDTO;
import universita.anagrafica.mapper.EdizioneCorsoMapper;
import universita.anagrafica.repository.EdizioneCorsoRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EdizioneCorsoService {

    private final EdizioneCorsoRepository edizioneCorsoRepository;

    private final EdizioneCorsoMapper edizioneCorsoMapper;

    public EdizioneCorsoService(EdizioneCorsoRepository edizioneCorsoRepository, EdizioneCorsoMapper edizioneCorsoMapper) {
        this.edizioneCorsoRepository = edizioneCorsoRepository;
        this.edizioneCorsoMapper = edizioneCorsoMapper;
    }

    public List<EdizioneCorsoDTO> listOfCorsi() {
        return edizioneCorsoRepository
                .findAll()
                .stream()
                .map(edizioneCorso -> edizioneCorsoMapper.toDto(edizioneCorso))
                .collect(Collectors.toList());
    }

    public EdizioneCorsoDTO edizioneCorsoPerNomeEAnno(String nome, String annoAccademico) {
        return edizioneCorsoMapper
                .toDto(edizioneCorsoRepository
                        .edizioneCorsoPerNomeAndAnnoAccademico(nome, annoAccademico));
    }

    public void saveEdizioneCorso(EdizioneCorsoDTO edizioneCorsoDTO) {
        edizioneCorsoRepository.save(edizioneCorsoMapper.toEntity(edizioneCorsoDTO));
    }
}
