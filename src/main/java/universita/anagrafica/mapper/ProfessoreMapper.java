package universita.anagrafica.mapper;

import org.mapstruct.Mapper;
import universita.anagrafica.mapper.domain.Professore;
import universita.anagrafica.dto.ProfessoreDTO;

@Mapper(componentModel = "spring")
public interface ProfessoreMapper extends EntityMapper<ProfessoreDTO, Professore>{
    ProfessoreDTO toDto(Professore professore);
    Professore toEntity(ProfessoreDTO professoreDTO);

    default Professore fromId(Integer matricola) {
        if (matricola == null) {
            return null;
        }
        Professore professore = new Professore();
        professore.setMatricola(matricola);
        return professore;
    }
}
