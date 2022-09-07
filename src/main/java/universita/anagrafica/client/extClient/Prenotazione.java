package universita.anagrafica.client.extClient;

import universita.anagrafica.kafka.Messaggio;

import java.util.Date;

public class Prenotazione extends Messaggio {

    private Integer edizioneCorso;
    private Integer corso;
    private Date dataAppello;
    private String nome;
    private Integer voto;
    private Integer studente;

    public Integer getEdizioneCorso() {
        return edizioneCorso;
    }

    public void setEdizioneCorso(Integer edizioneCorso) {
        this.edizioneCorso = edizioneCorso;
    }

    public Integer getCorso() {
        return corso;
    }

    public void setCorso(Integer corso) {
        this.corso = corso;
    }

    public Date getDataAppello() {
        return dataAppello;
    }

    public void setDataAppello(Date dataAppello) {
        this.dataAppello = dataAppello;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getVoto() {
        return voto;
    }

    public void setVoto(Integer voto) {
        this.voto = voto;
    }

    public Integer getStudente() {
        return studente;
    }

    public void setStudente(Integer studente) {
        this.studente = studente;
    }
}
