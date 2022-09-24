package universita.anagrafica.domain;

import javax.persistence.*;

@Entity
@Table(name = "tasse")
public class TassaStudente extends Tassa{

    @ManyToOne
    @JoinColumn(name = "studente")
    private Studente studente;

    @ManyToOne
    @JoinColumn(name = "studente_non_immatricolato")
    private StudenteNonImmatricolato studenteNonImmatricolato;

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
