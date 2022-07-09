package universita.anagrafica.mapper;

import org.mapstruct.Mapper;
import universita.anagrafica.mapper.domain.CorsoDiLaurea;
import universita.anagrafica.dto.CorsoDiLaureaDTO;

@Mapper(componentModel = "spring")
public interface CorsoDiLaureaMapper extends EntityMapper<CorsoDiLaureaDTO, CorsoDiLaurea>{

    CorsoDiLaureaDTO toDto(CorsoDiLaurea corsoDiLaurea);
    CorsoDiLaurea toEntity(CorsoDiLaureaDTO corsoDiLaureaDTO);

    default CorsoDiLaurea fromId(Integer id){
        if(id == null)
            return null;
        CorsoDiLaurea corsoDiLaurea = new CorsoDiLaurea();
        corsoDiLaurea.setId(id);
        return  corsoDiLaurea;
    }
}
