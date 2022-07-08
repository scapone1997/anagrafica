package universita.anagrafica.dto;

import universita.anagrafica.domain.Corso;

import java.util.Set;

public class CorsoDiLaureaDTO {
    private Integer id;
    private String nome;

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

    public Set<Corso> getCorsi() {
        return corsi;
    }

    public void setCorsi(Set<Corso> corsi) {
        this.corsi = corsi;
    }
}
