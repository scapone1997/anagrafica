package universita.anagrafica.controller.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import universita.anagrafica.dto.ProfessoreDTO;
import universita.anagrafica.dto.StudenteDTO;
import universita.anagrafica.service.ProfessoreService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProfessoreController {
    private final ProfessoreService professoreService;

    public ProfessoreController(ProfessoreService professoreService) {
        this.professoreService = professoreService;
    }

    @GetMapping(value = "/professori")
    public ResponseEntity<List<ProfessoreDTO>> allStudents(){
        List<ProfessoreDTO> list = professoreService.listOfProfessori();
        return ResponseEntity.ok().body(list);
    }

    @PostMapping(value = "/create-professore", consumes = "application/json")
    public ResponseEntity<ProfessoreDTO> createStudente(@RequestBody ProfessoreDTO professoreDTO){
        professoreService.saveProfessore(professoreDTO);
        return ResponseEntity.ok().body(professoreDTO);
    }
}
