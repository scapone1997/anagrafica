package universita.anagrafica.controller.rest;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import universita.anagrafica.dto.CorsoDTO;
import universita.anagrafica.dto.EdizioneCorsoDTO;
import universita.anagrafica.dto.ProfessoreDTO;
import universita.anagrafica.service.EdizioneCorsoService;

import java.util.List;

@RestController
@RequestMapping(value = "/api", produces = "application/json")
public class EdizioneCorsoController {

    private final EdizioneCorsoService edizioneCorsoService;

    public EdizioneCorsoController(EdizioneCorsoService edizioneCorsoService) {
        this.edizioneCorsoService = edizioneCorsoService;
    }

    @GetMapping("/edizione-corsi")
    public ResponseEntity<List<EdizioneCorsoDTO>> allEdizioniCorso(){
        List<EdizioneCorsoDTO> list = edizioneCorsoService.listOfCorsi();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/edizione-corso/{nome}/{annoAccademico}")
    public ResponseEntity<EdizioneCorsoDTO> edizioneCorsoPerNomeEAnno(@PathVariable String nome, @PathVariable String annoAccademico){
        EdizioneCorsoDTO edizioneCorsoDTO = edizioneCorsoService.edizioneCorsoPerNomeEAnno(nome, annoAccademico);
        return ResponseEntity.ok().body(edizioneCorsoDTO);
    }

    @PostMapping(value = "/create-edizione-corso", consumes = "application/json")
    public ResponseEntity<EdizioneCorsoDTO> createEdizioneCorso(@RequestBody EdizioneCorsoDTO edizioneCorsoDTO){
        edizioneCorsoService.saveEdizioneCorso(edizioneCorsoDTO);
        return ResponseEntity.ok().body(edizioneCorsoDTO);
    }

    @PutMapping(value = "/update-edizione-corso/{id}", consumes = "application/json")
    public ResponseEntity<EdizioneCorsoDTO> addProfessoreEdizioneCorso(@PathVariable Integer id, @RequestBody ProfessoreDTO professoreDTO){
        EdizioneCorsoDTO edizioneCorsoDTO = edizioneCorsoService.updateEdizioneCorso(id, professoreDTO);
        return ResponseEntity.ok().body(edizioneCorsoDTO);
    }
}
