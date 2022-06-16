package universita.anagrafica.domain;

import lombok.*;

import javax.persistence.Entity;
import java.time.LocalDate;

@Data
@RequiredArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public abstract class Persona {
    private String nome;
    private String cognome;
    private LocalDate dataNascita;
    private Character sesso;
    private String luogoNascita;
}
