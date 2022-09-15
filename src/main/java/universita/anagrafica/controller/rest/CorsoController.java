package universita.anagrafica.controller.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import universita.anagrafica.dto.CorsoDTO;
import universita.anagrafica.service.CorsoService;

import java.util.List;

@RestController
@RequestMapping(value = "/api", produces = "application/json")
public class CorsoController {

    private final CorsoService corsoService;

    public CorsoController(CorsoService corsoService) {
        this.corsoService = corsoService;
    }

    @GetMapping(value = "/corsi")
    public ResponseEntity<List<CorsoDTO>> allCorsi(){
        List<CorsoDTO> list = corsoService.listOfCorsi();
        return ResponseEntity.ok().body(list);
    }

    @PostMapping(value = "/create-corso", consumes = "application/json")
    public ResponseEntity<CorsoDTO> createCorso(@RequestBody CorsoDTO corsoDTO){
        corsoService.saveCorso(corsoDTO);
        return ResponseEntity.ok().body(corsoDTO);
    }

    @DeleteMapping(value = "/delete-corso/{id}")
    public ResponseEntity<String> deleteCorso(@PathVariable Integer id){
        corsoService.deleteCorso(id);
        return ResponseEntity.ok().body("Corso " + id + " eliminato. ");
    }

    @GetMapping(value = "/corsi/{corsoDiLaurea}")
    public ResponseEntity<List<CorsoDTO>> corsiPerCorsoDiLaurea(@PathVariable String corsoDiLaurea){
        return ResponseEntity.ok().body(corsoService.corsiPerCorsoDiLaurea(corsoDiLaurea));
    }
}
