package universita.anagrafica.dto;


import java.time.LocalDate;

public class CollaboratoreDTO extends PersonaDTO{
    private Integer codice;
    public CollaboratoreDTO(String nome, String cognome, LocalDate dataNascita, Character sesso, String luogoNascita, Integer codice) {
        super(nome, cognome, dataNascita, sesso, luogoNascita);
        this.codice = codice;
    }

    public Integer getCodice() {
        return codice;
    }

    public void setCodice(Integer codice) {
        this.codice = codice;
    }
}
