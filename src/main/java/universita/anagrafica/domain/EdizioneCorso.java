package universita.anagrafica.domain;


import javax.persistence.*;


@Entity
@Table(name = "edizione_corso")
public class EdizioneCorso {

    @Id
    private Integer id;

    @Column(name = "anno_accademico")
    private String annoAccademico;

    @ManyToOne
    @JoinColumn(name = "corso")
    private Corso corso;

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

    public Corso getCorso() {
        return corso;
    }

    public void setCorso(Corso corso) {
        this.corso = corso;
    }
}
