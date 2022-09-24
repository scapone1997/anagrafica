package universita.anagrafica.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "studente_non_immatricolato")
public class StudenteNonImmatricolato extends Persona{
    @Id
    private Integer matricola;

    @Column(name = "anno_accademico_iscrizione")
    private String annoAccademicoIscrizione;

    public StudenteNonImmatricolato() {
    }

    public Integer getMatricola() {
        return matricola;
    }

    public void setMatricola(Integer matricola) {
        this.matricola = matricola;
    }

    public String getAnnoAccademicoIscrizione() {
        return annoAccademicoIscrizione;
    }

    public void setAnnoAccademicoIscrizione(String annoAccademicoIscrizione) {
        this.annoAccademicoIscrizione = annoAccademicoIscrizione;
    }

    @Override
    public String toString() {
        return "Studente{" +
                "matricola=" + matricola +
                ", annoAccademicoIscrizione='" + annoAccademicoIscrizione + '\'' +
                '}';
    }
}
