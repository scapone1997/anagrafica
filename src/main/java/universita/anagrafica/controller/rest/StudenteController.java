package universita.anagrafica.controller.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import universita.anagrafica.domain.Studente;
import universita.anagrafica.dto.StudenteDTO;
import universita.anagrafica.service.StudenteService;

@RestController
@RequestMapping(value = "/api", produces = "application/json")
public class StudenteController {
    private final StudenteService studenteService;

    public StudenteController(StudenteService studenteService) {
        this.studenteService = studenteService;
    }

    @PostMapping(value = "/create-studente", consumes = "application/json")
    public ResponseEntity<StudenteDTO> createStudente(@RequestBody StudenteDTO studenteDTO){
        studenteService.saveStudente(studenteDTO);
        return ResponseEntity.ok().body(studenteDTO);
    }

}
