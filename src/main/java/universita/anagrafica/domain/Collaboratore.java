package universita.anagrafica.domain;

import lombok.*;

import javax.persistence.Entity;

@Data
@Entity
@RequiredArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class Collaboratore extends Persona{
    private Integer codice;
}
