package universita.anagrafica.domain;

import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
public abstract class Tassa {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "importo_base")
    private Double importoBase;

    private String descrizione;

    private Boolean pagata;

    private Boolean scaduta;

    @Column(name = "data_scadenza")
    private Date dataScadenza;

    public Tassa() {
    }

    public Tassa(Double importoBase) {
        this.importoBase = importoBase;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getImportoBase() {
        return importoBase;
    }

    public void setImportoBase(Double importoBase) {
        this.importoBase = importoBase;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public Boolean getPagata() {
        return pagata;
    }

    public void setPagata(Boolean pagata) {
        this.pagata = pagata;
    }

    public Boolean getScaduta() {
        return scaduta;
    }

    public void setScaduta(Boolean scaduta) {
        this.scaduta = scaduta;
    }

    public Date getDataScadenza() {
        return dataScadenza;
    }

    public void setDataScadenza(Date dataScadenza) {
        this.dataScadenza = dataScadenza;
    }
}
