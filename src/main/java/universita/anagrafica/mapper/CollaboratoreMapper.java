package universita.anagrafica.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import universita.anagrafica.domain.Collaboratore;
import universita.anagrafica.dto.CollaboratoreDTO;

@Mapper(componentModel = "spring")
public interface CollaboratoreMapper {
    CollaboratoreMapper INSTANCE = Mappers.getMapper(CollaboratoreMapper.class);

    CollaboratoreDTO collaboratoreToCollaboratoreDTO(Collaboratore collaboratore);
    Collaboratore collaboratoreDTOToCollaboratore(CollaboratoreDTO collaboratoreDTO);
}
