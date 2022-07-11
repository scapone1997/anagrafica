package universita.anagrafica.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "edizione_corso")
public class EdizioneCorso {

    @Id
    private Integer id;

    @Column(name = "anno_accademico")
    private String annoAccademico;

    @JoinTable(
            name = "edizione_corso_professori",
            joinColumns = @JoinColumn(name = "edizione_corso"),
            inverseJoinColumns = @JoinColumn(name = "professore"))
    private Set<Professore> professore = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "corso")
    private Corso corso;
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAnnoAccademico() {
        return annoAccademico;
    }

    public void setAnnoAccademico(String annoAccademico) {
        this.annoAccademico = annoAccademico;
    }

    public Corso getCorso() {
        return corso;
    }

    public void setCorso(Corso corso) {
        this.corso = corso;
    }

    public void setProfessoreSet(Set<Professore> professoreSet) {
        this.professore = professoreSet;
    }

    public Set<Professore> getProfessoreSet() {
        return professore;
    }
}
