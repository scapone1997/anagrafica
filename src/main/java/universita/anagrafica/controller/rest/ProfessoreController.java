package universita.anagrafica.controller.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import universita.anagrafica.service.ProfessoreService;

@RestController
@RequestMapping("/api")
public class ProfessoreController {
    private final ProfessoreService professoreService;

    public ProfessoreController(ProfessoreService professoreService) {
        this.professoreService = professoreService;
    }
}
