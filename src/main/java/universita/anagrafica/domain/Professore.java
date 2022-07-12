package universita.anagrafica.domain;


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
public class Professore extends Persona{
    @Id
    private Integer matricola;

    @ManyToMany(mappedBy = "professore")
    private List<EdizioneCorso> edizioneCorso = new ArrayList<>();

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

    public List<EdizioneCorso> getEdizioneCorso() {
        return edizioneCorso;
    }

    public void setEdizioneCorso(List<EdizioneCorso> edizioneCorso) {
        this.edizioneCorso = edizioneCorso;
    }
}
