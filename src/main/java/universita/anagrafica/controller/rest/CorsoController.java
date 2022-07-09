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
        //try{
            corsoService.saveCorso(corsoDTO);
       // }catch (Exception e){
            //System.out.println("Lanciata eccezione: " + e.);
            //return ResponseEntity.badRequest().body(null);
        //}
        return ResponseEntity.ok().body(corsoDTO);
    }
}
