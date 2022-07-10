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
}
