package universita.anagrafica.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import universita.anagrafica.domain.Corso;
import universita.anagrafica.dto.CorsoDTO;

@Mapper(componentModel = "spring")
public interface CorsoMapper {

    CorsoMapper INSTANCE = Mappers.getMapper(CorsoMapper.class);

    CorsoDTO corsoToCorsoDTO(Corso corso);
    Corso corsoDTOToCorso(CorsoDTO corsoDTO);

}
