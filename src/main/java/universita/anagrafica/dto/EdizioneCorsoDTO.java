package universita.anagrafica.dto;

import universita.anagrafica.domain.Corso;

public class EdizioneCorsoDTO {

    private Integer id;

    private String annoAccademico;

    private Integer corso;

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
}
