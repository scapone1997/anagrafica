package universita.anagrafica.controller.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import universita.anagrafica.dto.StudenteDTO;
import universita.anagrafica.service.StudenteService;

@RestController
@RequestMapping("/api")
public class StudenteController {
    private final StudenteService studenteService;

    public StudenteController(StudenteService studenteService) {
        this.studenteService = studenteService;
    }

    @PutMapping("/create-studente")
    public ResponseEntity<StudenteDTO> createStudente(@RequestBody StudenteDTO studenteDTO){
        studenteService.saveStudente(studenteDTO);
        return ResponseEntity.ok().body(studenteDTO);
    }
}
