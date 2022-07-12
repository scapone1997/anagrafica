package universita.anagrafica.dto;

import universita.anagrafica.domain.Corso;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class EdizioneCorsoDTO {

    private Integer id;

    private String annoAccademico;

    private Integer corso;

    private List<ProfessoreDTO> professore = new ArrayList<>();

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

    public Integer getCorso() {
        return corso;
    }

    public void setCorso(Integer corso) {
        this.corso = corso;
    }

    public List<ProfessoreDTO> getProfessore() {
        return professore;
    }

    public void setProfessore(List<ProfessoreDTO> professore) {
        this.professore = professore;
    }
}
