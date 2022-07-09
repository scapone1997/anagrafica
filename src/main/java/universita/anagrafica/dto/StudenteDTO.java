package universita.anagrafica.dto;

import java.time.LocalDate;

public class StudenteDTO extends PersonaDTO{
    private Integer matricola;

    private Integer corsoDiLaurea;

    public StudenteDTO(String nome, String cognome, LocalDate dataNascita, Character sesso, String luogoNascita, Integer matricola) {
        super(nome, cognome, dataNascita, sesso, luogoNascita);
        this.matricola = matricola;
    }

    public Integer getMatricola() {
        return matricola;
    }

    public void setMatricola(Integer matricola) {
        this.matricola = matricola;
    }

    public Integer getCorsoDiLaurea() {
        return corsoDiLaurea;
    }

    public void setCorsoDiLaurea(Integer corsoDiLaurea) {
        this.corsoDiLaurea = corsoDiLaurea;
    }
}
