package universita.anagrafica.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity(name = "corso_di_laurea")
public class CorsoDiLaurea {

    @Id
    private Integer id;
    private String nome;

    @OneToMany(mappedBy = "corsoDiLaurea")
    private Set<Corso> corsi;

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
}
