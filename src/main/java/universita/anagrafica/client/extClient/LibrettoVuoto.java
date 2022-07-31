package universita.anagrafica.client.extClient;


import java.util.List;

public class LibrettoVuoto {
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
}
