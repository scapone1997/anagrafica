package universita.anagrafica.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import universita.anagrafica.domain.Studente;
import universita.anagrafica.dto.StudenteDTO;

@Mapper(componentModel = "spring", uses = {CorsoDiLaureaMapper.class})
public interface StudenteMapper extends EntityMapper<StudenteDTO, Studente>{

    @Mapping(source="corsoDiLaurea.id", target = "corsoDiLaurea")
    StudenteDTO toDto(Studente studente);

    @Mapping(source = "corsoDiLaurea", target = "corsoDiLaurea")
    Studente toEntity(StudenteDTO studenteDTO);

    default Studente fromMatricola(Integer matricola){
        if(matricola == null)
            return null;
        Studente studente = new Studente();
        studente.setMatricola(matricola);
        return studente;
    }

}
