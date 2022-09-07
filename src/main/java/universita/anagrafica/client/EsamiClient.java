package universita.anagrafica.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import universita.anagrafica.client.extClient.ControlloCorsoStudente;
import universita.anagrafica.client.extClient.LibrettoVuoto;
import universita.anagrafica.client.extClient.Prenotazione;

import java.net.CacheRequest;


@Component
@FeignClient(url = "${esami.ribbon.listOfServers}/api", name = "esami")
public interface EsamiClient {

    @PostMapping("/carica-libretto")
    ResponseEntity<String> caricaLibretto(@RequestBody LibrettoVuoto librettoVuoto) throws Exception;

    @DeleteMapping("/elimina-libretto")
    ResponseEntity<String> eliminaLibretto(Integer matricola) throws Exception;

    @GetMapping("/esiste-corso-non-verbalizzato")
    ResponseEntity<Boolean> isCorsoNonVerbalizzato(@RequestBody ControlloCorsoStudente corsoStudente);

    @PostMapping("/prenota-studente")
    ResponseEntity<String> prenotaStudente(@RequestBody Prenotazione prenotazione);
}
