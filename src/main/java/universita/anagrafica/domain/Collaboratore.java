package universita.anagrafica.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDate;
@Entity
@Table(name = "collaboratore")
public class Collaboratore extends Persona implements Serializable {

    @Id
    private Integer codice;

    public Collaboratore(){

    }

    public Integer getCodice() {
        return codice;
    }

    public void setCodice(Integer codice) {
        this.codice = codice;
    }
}
