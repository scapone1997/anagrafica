package universita.anagrafica.service;

import org.springframework.stereotype.Service;
import universita.anagrafica.domain.EdizioneCorso;
import universita.anagrafica.domain.Professore;
import universita.anagrafica.dto.CorsoDTO;
import universita.anagrafica.dto.EdizioneCorsoDTO;
import universita.anagrafica.dto.ProfessoreDTO;
import universita.anagrafica.mapper.EdizioneCorsoMapper;
import universita.anagrafica.mapper.ProfessoreMapper;
import universita.anagrafica.repository.EdizioneCorsoRepository;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class EdizioneCorsoService {

    private final EdizioneCorsoRepository edizioneCorsoRepository;

    private final ProfessoreMapper professoreMapper;

    private final EdizioneCorsoMapper edizioneCorsoMapper;

    public EdizioneCorsoService(EdizioneCorsoRepository edizioneCorsoRepository, ProfessoreMapper professoreMapper, EdizioneCorsoMapper edizioneCorsoMapper) {
        this.edizioneCorsoRepository = edizioneCorsoRepository;
        this.professoreMapper = professoreMapper;
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

    public EdizioneCorsoDTO updateEdizioneCorso(Integer id, ProfessoreDTO professoreDTO) {

        /*
        Optional<EdizioneCorso> edizioneCorso = edizioneCorsoRepository.findById(id);
        EdizioneCorso edizioneCorso1 = null;
        Set<Professore> set = null;
        if(edizioneCorso.isPresent()){
            edizioneCorso1 = edizioneCorso.get();
            set = edizioneCorso1.getProfessore();
            set.add(professoreMapper.toEntity(professoreDTO));
            edizioneCorsoRepository.save(e)
        }

         */

        edizioneCorsoRepository.findById(id).ifPresent(ec->{
            ec.getProfessore().add(professoreMapper.toEntity(professoreDTO));
            edizioneCorsoRepository.save(ec);
        });

        return edizioneCorsoMapper.toDto(edizioneCorsoRepository.findById(id).get());
    }
}
