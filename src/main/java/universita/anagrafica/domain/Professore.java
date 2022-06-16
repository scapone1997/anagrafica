package universita.anagrafica.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.criteria.CriteriaBuilder;

@Data
@Entity
@RequiredArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class Professore extends Persona{
    private Integer matricola;
}
