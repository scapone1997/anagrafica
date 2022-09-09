package universita.anagrafica.client;

import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import universita.anagrafica.client.extClient.ControlloCorsoStudente;
import universita.anagrafica.client.extClient.LibrettoVuoto;
import universita.anagrafica.client.extClient.Prenotazione;

@Component
@FeignClient(url = "${esami.ribbon.listOfServers}/api", name = "esami")
public interface EsamiClient {

    @PostMapping("/carica-libretto")
    ResponseEntity<String> caricaLibretto(@RequestBody LibrettoVuoto librettoVuoto) throws Exception;

    @DeleteMapping("/elimina-libretto")
    ResponseEntity<String> eliminaLibretto(Integer matricola) throws Exception;

    @RequestMapping(method = RequestMethod.GET, value = "/esiste-corso-non-verbalizzato")
    @Headers(value = "Content-Type: application/json")
    ResponseEntity<Boolean> isCorsoNonVerbalizzato(@RequestBody ControlloCorsoStudente corsoStudente) throws Exception;

    @PostMapping("/prenota-studente")
    ResponseEntity<String> prenotaStudente(@RequestBody Prenotazione prenotazione);
}
