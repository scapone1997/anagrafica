package universita.anagrafica.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "studente")
public class Studente extends StudenteNonImmatricolato implements Serializable {

    @ManyToOne
    @JoinColumn(name = "corso_di_laurea")
    private CorsoDiLaurea corsoDiLaurea;

    private Boolean attivo;

    private Boolean laureato;

    public Studente(){

    }
    public CorsoDiLaurea getCorsoDiLaurea() {
        return corsoDiLaurea;
    }

    public void setCorsoDiLaurea(CorsoDiLaurea corsoDiLaurea) {
        this.corsoDiLaurea = corsoDiLaurea;
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
}
