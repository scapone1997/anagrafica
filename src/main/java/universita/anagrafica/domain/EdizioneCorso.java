package universita.anagrafica.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "edizione_corso")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class EdizioneCorso {

    @Id
    private Integer id;

    @Column(name = "anno_accademico")
    private String annoAccademico;

    @ManyToOne
    @JoinColumn(name = "corso")
    private Corso corso;

    @ManyToMany
    @JoinTable(
            name = "edizione_corso_professori",
            joinColumns = @JoinColumn(name = "edizione_corso"),
            inverseJoinColumns = @JoinColumn(name = "professore"))
    private Set<Professore> professore = new HashSet<>();

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

    public Set<Professore> getProfessore() {
        return professore;
    }

    public void setProfessore(Set<Professore> professore) {
        this.professore = professore;
    }
}
