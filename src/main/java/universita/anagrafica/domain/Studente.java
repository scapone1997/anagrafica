package universita.anagrafica.domain;

import liquibase.pro.packaged.H;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;

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
