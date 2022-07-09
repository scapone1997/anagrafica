package universita.anagrafica.domain;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "studente")
public class Studente extends Persona{

    @Id
    private Integer matricola;

    @ManyToOne
    @JoinColumn(name = "corso_di_laurea")
    private CorsoDiLaurea corsoDiLaurea;

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

    public CorsoDiLaurea getCorsoDiLaurea() {
        return corsoDiLaurea;
    }

    public void setCorsoDiLaurea(CorsoDiLaurea corsoDiLaurea) {
        this.corsoDiLaurea = corsoDiLaurea;
    }

    @Override
    public String toString() {
        return "Studente{" +
                "matricola=" + matricola +
                '}';
    }
}
