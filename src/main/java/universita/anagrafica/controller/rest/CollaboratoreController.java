package universita.anagrafica.controller.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import universita.anagrafica.dto.CollaboratoreDTO;
import universita.anagrafica.dto.ProfessoreDTO;
import universita.anagrafica.service.CollaboratoreService;
import universita.anagrafica.service.ProfessoreService;

@RestController
@RequestMapping("/api")
public class CollaboratoreController {
    private final CollaboratoreService collaboratoreService;

    public CollaboratoreController(CollaboratoreService collaboratoreService) {
        this.collaboratoreService = collaboratoreService;
    }

    @PostMapping(value = "/create-collaboratore", consumes = "application/json")
    public ResponseEntity<CollaboratoreDTO> createStudente(@RequestBody CollaboratoreDTO collaboratoreDTO){
        collaboratoreService.saveCollaboratore(collaboratoreDTO);
        return ResponseEntity.ok().body(collaboratoreDTO);
    }
}
