package universita.anagrafica.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
public abstract class PersonaDTO {
    private String nome;
    private String cognome;
    private LocalDate dataNascita;
    private Character sesso;
    private String luogoNascita;
}
