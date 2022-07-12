package universita.anagrafica.dto;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class ProfessoreDTO extends PersonaDTO {
    private Integer matricola;

    private Set<EdizioneCorsoDTO> edizioneCorso = new HashSet<>();

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

    public Set<EdizioneCorsoDTO> getEdizioneCorso() {
        return edizioneCorso;
    }

    public void setEdizioneCorso(Set<EdizioneCorsoDTO> edizioneCorso) {
        this.edizioneCorso = edizioneCorso;
    }
}
