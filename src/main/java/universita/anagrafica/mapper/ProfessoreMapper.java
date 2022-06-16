package universita.anagrafica.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import universita.anagrafica.domain.Professore;
import universita.anagrafica.dto.ProfessoreDTO;

@Mapper(componentModel = "spring")
public interface ProfessoreMapper {
    ProfessoreMapper INSTANCE = Mappers.getMapper(ProfessoreMapper.class);

    ProfessoreDTO professoreToProfessoreDTO(Professore professore);
    Professore professoreDTOToProfessore(ProfessoreDTO professoreDTO);
}
