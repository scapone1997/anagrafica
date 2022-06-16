package universita.anagrafica.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.criteria.CriteriaBuilder;
import java.time.LocalDate;

@Entity(name = "professore")
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
