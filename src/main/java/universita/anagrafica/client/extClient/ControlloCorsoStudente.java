package universita.anagrafica.client.extClient;

public class ControlloCorsoStudente {

    private Integer studente;
    private Integer corso;

    public Integer getStudente() {
        return studente;
    }

    public void setStudente(Integer studente) {
        this.studente = studente;
    }

    public Integer getCorso() {
        return corso;
    }

    public void setCorso(Integer corso) {
        this.corso = corso;
    }

    @Override
    public String toString() {
        return "ControlloCorsoStudente{" +
                "studente=" + studente +
                ", corso=" + corso +
                '}';
    }
}
