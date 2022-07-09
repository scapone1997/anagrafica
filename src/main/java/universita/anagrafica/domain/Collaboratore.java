package universita.anagrafica.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;
@Entity
@Table(name = "collaboratore")
public class Collaboratore extends Persona{

    @Id
    private Integer codice;

    public Collaboratore(){

    }

    public Collaboratore(String nome, String cognome, LocalDate dataNascita, Character sesso, String luogoNascita, Integer codice) {
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
