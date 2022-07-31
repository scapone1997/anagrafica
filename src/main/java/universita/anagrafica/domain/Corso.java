package universita.anagrafica.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "corso")
public class Corso implements Serializable {

    @Id
    private Integer id;
    private String nome;
    private Boolean obbligatorio;

    @ManyToOne
    @JoinColumn(name = "corso_di_laurea")
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

    public CorsoDiLaurea getCorsoDiLaurea() {
        return corsoDiLaurea;
    }

    public void setCorsoDiLaurea(CorsoDiLaurea corsoDiLaurea) {
        this.corsoDiLaurea = corsoDiLaurea;
    }
}
