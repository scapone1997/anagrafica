package universita.anagrafica.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tasse")
public class TassaStudente extends Tassa{

    @ManyToOne
    private Studente studente;

    @Column(name = "importo_reale")
    private Double importoReale;

    public TassaStudente(Studente studente) {
        this.studente = studente;
        calcolaImporto();
    }

    public TassaStudente(){

    }

    private void calcolaImporto(){
        //TODO con l'ISEE
        importoReale = 24.5;
    }
}
