package universita.anagrafica.domain;

import javax.persistence.*;
import java.util.HashSet;

@Entity(name = "corso")
public class Corso {

    @Id
    private Integer id;
    private String nome;
    private Boolean obbligatorio;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "professore", referencedColumnName = "matricola")
    private Professore professore;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "corso_di_laurea", referencedColumnName = "id")
    private CorsoDiLaurea corsoDiLaurea;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Boolean getObbligatorio() {
        return obbligatorio;
    }

    public void setObbligatorio(Boolean obbligatorio) {
        this.obbligatorio = obbligatorio;
    }

    public Professore getProfessore() {
        return professore;
    }

    public void setProfessore(Professore professore) {
        this.professore = professore;
    }
}
