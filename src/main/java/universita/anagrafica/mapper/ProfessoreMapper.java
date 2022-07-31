package universita.anagrafica.mapper;

import org.mapstruct.Mapper;
import universita.anagrafica.domain.Professore;
import universita.anagrafica.dto.ProfessoreDTO;

@Mapper(componentModel = "spring", uses = {EdizioneCorsoMapper.class})
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
