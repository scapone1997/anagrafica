package universita.anagrafica.controller.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import universita.anagrafica.dto.ProfessoreDTO;
import universita.anagrafica.dto.StudenteDTO;
import universita.anagrafica.service.ProfessoreService;

@RestController
@RequestMapping("/api")
public class ProfessoreController {
    private final ProfessoreService professoreService;

    public ProfessoreController(ProfessoreService professoreService) {
        this.professoreService = professoreService;
    }

    @PostMapping(value = "/create-professore", consumes = "application/json")
    public ResponseEntity<ProfessoreDTO> createStudente(@RequestBody ProfessoreDTO professoreDTO){
        professoreService.saveProfessore(professoreDTO);
        return ResponseEntity.ok().body(professoreDTO);
    }
}
