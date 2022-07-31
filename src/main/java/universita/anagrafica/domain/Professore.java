package universita.anagrafica.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "professore")
public class Professore extends Persona implements Serializable {
    @Id
    private Integer matricola;

    @ManyToMany(mappedBy = "professore")
    @JsonIgnore
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
