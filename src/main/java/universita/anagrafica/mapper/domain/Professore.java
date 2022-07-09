package universita.anagrafica.mapper.domain;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "professore")
public class Professore extends Persona{
    @Id
    private Integer matricola;

    public Professore(){

    }
    public Professore(String nome, String cognome, LocalDate dataNascita, Character sesso, String luogoNascita, Integer matricola) {
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
