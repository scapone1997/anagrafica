package universita.anagrafica.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import universita.anagrafica.domain.Studente;
import universita.anagrafica.dto.StudenteDTO;

@Mapper(componentModel = "spring")
public interface StudenteMapper {

    StudenteMapper INSTANCE = Mappers.getMapper(StudenteMapper.class);

    StudenteDTO studenteToStudenteDTO(Studente studente);
    Studente studenteDTOToStudente(StudenteDTO studenteDTO);
}
