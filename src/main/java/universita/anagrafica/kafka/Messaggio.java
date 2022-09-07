package universita.anagrafica.kafka;

public abstract class Messaggio {

    public String codice;

    public String getCodice() {
        return codice;
    }

    public void setCodice(String codice) {
        this.codice = codice;
    }

    @Override
    public String toString() {
        return "Messaggio{" +
                "codice='" + codice + '\'' +
                '}';
    }
}
