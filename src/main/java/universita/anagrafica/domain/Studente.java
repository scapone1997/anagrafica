package universita.anagrafica.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity(name = "studente")
public class Studente extends Persona{

    @Id
    private Integer matricola;

    public Studente(){

    }

    public Studente(String nome, String cognome, LocalDate dataNascita, Character sesso, String luogoNascita, Integer matricola){
        super(nome, cognome, dataNascita, sesso, luogoNascita);
        this.matricola = matricola;
    }

    public Integer getMatricola() {
        return matricola;
    }

    public void setMatricola(Integer matricola) {
        this.matricola = matricola;
    }


    @Override
    public String toString() {
        return "Studente{" +
                "matricola=" + matricola +
                '}';
    }
}
