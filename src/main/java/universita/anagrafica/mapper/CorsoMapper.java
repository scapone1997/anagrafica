package universita.anagrafica.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import universita.anagrafica.domain.Corso;
import universita.anagrafica.dto.CorsoDTO;

@Mapper(componentModel = "spring", uses = {CorsoDiLaureaMapper.class})
public interface CorsoMapper extends EntityMapper<CorsoDTO, Corso>{

    @Mapping(source="corsoDiLaurea.id", target = "corsoDiLaurea")
    CorsoDTO toDto(Corso corso);

    @Mapping(source = "corsoDiLaurea", target = "corsoDiLaurea")
    Corso toEntity(CorsoDTO corsoDTO);

    default Corso fromId(Integer id){
        if(id == null)
            return null;
        Corso corso = new Corso();
        corso.setId(id);
        return corso;
    }

}
