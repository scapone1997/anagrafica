package universita.anagrafica.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import universita.anagrafica.domain.EdizioneCorso;
import universita.anagrafica.dto.EdizioneCorsoDTO;

@Mapper(componentModel = "spring", uses = {CorsoMapper.class})
public interface EdizioneCorsoMapper {

    @Mapping(source="corso.id", target = "corso")
    EdizioneCorsoDTO toDto(EdizioneCorso corso);

    @Mapping(source = "corso", target = "corso")
    EdizioneCorso toEntity(EdizioneCorsoDTO corsoDTO);

    default EdizioneCorso fromId(Integer id){
        if(id == null)
            return null;
        EdizioneCorso edizioneCorso = new EdizioneCorso();
        edizioneCorso.setId(id);
        return edizioneCorso;
    }
}
