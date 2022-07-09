package universita.anagrafica.dto;

import universita.anagrafica.domain.CorsoDiLaurea;
import universita.anagrafica.domain.Professore;


public class CorsoDTO {

    private Integer id;
    private String nome;
    private Boolean obbligatorio;

    private Integer professoreMatricola;


    private Integer corsoDiLaureaId;

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

    public Integer getProfessoreMatricola() {
        return professoreMatricola;
    }

    public void setProfessoreMatricola(Integer professoreMatricola) {
        this.professoreMatricola = professoreMatricola;
    }

    public Integer getCorsoDiLaureaId() {
        return corsoDiLaureaId;
    }

    public void setCorsoDiLaureaId(Integer corsoDiLaureaId) {
        this.corsoDiLaureaId = corsoDiLaureaId;
    }
}
