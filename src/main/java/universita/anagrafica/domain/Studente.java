package universita.anagrafica.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "studente")
public class Studente extends Persona implements Serializable {

    @Id
    private Integer matricola;

    @Column(name = "anno_accademico_iscrizione")
    private String annoAccademicoIscrizione;

    @ManyToOne
    @JoinColumn(name = "corso_di_laurea")
    private CorsoDiLaurea corsoDiLaurea;

    private Boolean attivo;

    private Boolean laureato;

    public Studente(){

    }

    public Integer getMatricola() {
        return matricola;
    }

    public void setMatricola(Integer matricola) {
        this.matricola = matricola;
    }

    public CorsoDiLaurea getCorsoDiLaurea() {
        return corsoDiLaurea;
    }

    public void setCorsoDiLaurea(CorsoDiLaurea corsoDiLaurea) {
        this.corsoDiLaurea = corsoDiLaurea;
    }

    public String getAnnoAccademicoIscrizione() {
        return annoAccademicoIscrizione;
    }

    public void setAnnoAccademicoIscrizione(String annoAccademicoIscrizione) {
        this.annoAccademicoIscrizione = annoAccademicoIscrizione;
    }

    public Boolean getAttivo() {
        return attivo;
    }

    public void setAttivo(Boolean attivo) {
        this.attivo = attivo;
    }

    public Boolean getLaureato() {
        return laureato;
    }

    public void setLaureato(Boolean laureato) {
        this.laureato = laureato;
    }

    @Override
    public String toString() {
        return "Studente{" +
                "matricola=" + matricola +
                ", annoAccademicoIscrizione='" + annoAccademicoIscrizione + '\'' +
                ", corsoDiLaurea=" + corsoDiLaurea +
                '}';
    }
}
