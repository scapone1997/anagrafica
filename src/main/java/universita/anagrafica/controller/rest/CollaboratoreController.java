package universita.anagrafica.controller.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import universita.anagrafica.service.CollaboratoreService;

@RestController
@RequestMapping("/api")
public class CollaboratoreController {
    private final CollaboratoreService collaboratoreService;

    public CollaboratoreController(CollaboratoreService collaboratoreService) {
        this.collaboratoreService = collaboratoreService;
    }
}
