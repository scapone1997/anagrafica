package universita.anagrafica.client.extClient;


import universita.anagrafica.kafka.Messaggio;

import java.util.List;

public class LibrettoVuoto extends Messaggio {
    private Integer matricola;
    private List<EsameObbligatorio> esami;

    public Integer getMatricola() {
        return matricola;
    }

    public void setMatricola(Integer matricola) {
        this.matricola = matricola;
    }

    public List<EsameObbligatorio> getEsami() {
        return esami;
    }

    public void setEsami(List<EsameObbligatorio> esami) {
        this.esami = esami;
    }

    @Override
    public String toString() {
        return "LibrettoVuoto{" +
                "matricola=" + matricola +
                ", esami=" + esami +
                '}';
    }
}
