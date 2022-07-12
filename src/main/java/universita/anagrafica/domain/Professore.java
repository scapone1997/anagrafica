package universita.anagrafica.domain;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "professore")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "matricola")
public class Professore extends Persona{
    @Id
    private Integer matricola;

    @ManyToMany(mappedBy = "professore")
    private Set<EdizioneCorso> edizioneCorso = new HashSet<>();

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

    public Set<EdizioneCorso> getEdizioneCorso() {
        return edizioneCorso;
    }

    public void setEdizioneCorso(Set<EdizioneCorso> edizioneCorso) {
        this.edizioneCorso = edizioneCorso;
    }
}
