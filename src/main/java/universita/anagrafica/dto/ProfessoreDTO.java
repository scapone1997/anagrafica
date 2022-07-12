package universita.anagrafica.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ProfessoreDTO extends PersonaDTO {
    private Integer matricola;

    private List<EdizioneCorsoDTO> edizioneCorso = new ArrayList<>();

    public ProfessoreDTO(String nome, String cognome, LocalDate dataNascita, Character sesso, String luogoNascita, Integer matricola) {
        super(nome, cognome, dataNascita, sesso, luogoNascita);
        this.matricola = matricola;
    }

    public Integer getMatricola() {
        return matricola;
    }

    public void setMatricola(Integer matricola) {
        this.matricola = matricola;
    }

    public List<EdizioneCorsoDTO> getEdizioneCorso() {
        return edizioneCorso;
    }

    public void setEdizioneCorso(List<EdizioneCorsoDTO> edizioneCorso) {
        this.edizioneCorso = edizioneCorso;
    }
}
