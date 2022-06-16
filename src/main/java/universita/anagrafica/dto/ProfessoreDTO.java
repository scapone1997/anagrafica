package universita.anagrafica.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import universita.anagrafica.domain.Persona;

import java.time.LocalDate;

@Data
public class ProfessoreDTO extends PersonaDTO {
    private Integer matricola;

    public ProfessoreDTO(String nome, String cognome, LocalDate dataNascita, Character sesso, String luogoNascita, Integer matricola) {
        super(nome, cognome, dataNascita, sesso, luogoNascita);
        this.matricola = matricola;
    }

    public Integer getMatricola() {
        return matricola;
    }

    public void setMatricola(Integer matricola) {
        this.matricola = matricola;
    }
}
