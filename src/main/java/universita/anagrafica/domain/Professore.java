package universita.anagrafica.domain;


import liquibase.pro.packaged.H;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "professore")
public class Professore extends Persona{
    @Id
    private Integer matricola;


    @OneToMany(mappedBy = "professore")
    private Set<Corso> corsi;

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
