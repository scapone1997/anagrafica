package universita.anagrafica.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import universita.anagrafica.domain.CorsoDiLaurea;
import universita.anagrafica.dto.CorsoDiLaureaDTO;

@Mapper(componentModel = "spring")
public interface CorsoDiLaureaMapper {

    CorsoDiLaureaMapper INSTANCE = Mappers.getMapper(CorsoDiLaureaMapper.class);

    CorsoDiLaureaDTO corsoDiLaureaToCorsoDiLaureaDTO(CorsoDiLaurea corsoDiLaurea);
    CorsoDiLaurea corsoDiLaureaDTOToCorsoDiLaurea(CorsoDiLaureaDTO corsoDiLaureaDTO);
}
