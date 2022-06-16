package universita.anagrafica.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

public abstract class PersonaDTO {
    private String nome;
    private String cognome;
    private LocalDate dataNascita;
    private Character sesso;
    private String luogoNascita;

    public PersonaDTO(String nome, String cognome, LocalDate dataNascita, Character sesso, String luogoNascita) {
        this.nome = nome;
        this.cognome = cognome;
        this.dataNascita = dataNascita;
        this.sesso = sesso;
        this.luogoNascita = luogoNascita;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public LocalDate getDataNascita() {
        return dataNascita;
    }

    public void setDataNascita(LocalDate dataNascita) {
        this.dataNascita = dataNascita;
    }

    public Character getSesso() {
        return sesso;
    }

    public void setSesso(Character sesso) {
        this.sesso = sesso;
    }

    public String getLuogoNascita() {
        return luogoNascita;
    }

    public void setLuogoNascita(String luogoNascita) {
        this.luogoNascita = luogoNascita;
    }
}
