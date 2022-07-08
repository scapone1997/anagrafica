package universita.anagrafica.controller.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import universita.anagrafica.domain.CorsoDiLaurea;
import universita.anagrafica.dto.CorsoDTO;
import universita.anagrafica.dto.CorsoDiLaureaDTO;
import universita.anagrafica.service.CorsoDiLaureaService;

import java.util.List;

@RestController
@RequestMapping(value = "/api", produces = "application/json")
public class CorsoDiLaureaController {

    private final CorsoDiLaureaService corsoDiLaureaService;

    public CorsoDiLaureaController(CorsoDiLaureaService corsoDiLaureaService) {
        this.corsoDiLaureaService = corsoDiLaureaService;
    }

    @GetMapping(value = "/corsi-di-laurea")
    public ResponseEntity<List<CorsoDiLaureaDTO>> allCorsiDiLaurea(){
        List<CorsoDiLaureaDTO> list = corsoDiLaureaService.listOfCorsiDiLaurea();
        return ResponseEntity.ok().body(list);
    }

    @PostMapping(value = "/create-corso-di-laurea", consumes = "application/json")
    public ResponseEntity<CorsoDiLaureaDTO> createCorso(@RequestBody CorsoDiLaureaDTO corsoDiLaureaDTO){
        corsoDiLaureaService.saveCorsoDiLaurea(corsoDiLaureaDTO);
        return ResponseEntity.ok().body(corsoDiLaureaDTO);
    }
}
