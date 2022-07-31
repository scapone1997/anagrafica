package universita.anagrafica.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import universita.anagrafica.client.extClient.LibrettoVuoto;


@Component
@FeignClient(url = "${esami.ribbon.listOfServers}/api", name = "esami")
public interface EsamiClient {

    @PostMapping("/carica-libretto")
    ResponseEntity<String> caricaLibretto(LibrettoVuoto librettoVuoto) throws Exception;
}
