package universita.anagrafica.controller.rest;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import universita.anagrafica.dto.StudenteDTO;
import universita.anagrafica.service.StudenteService;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(value = "/api", produces = "application/json")
public class StudenteController {
    private final StudenteService studenteService;

    public StudenteController(StudenteService studenteService) {
        this.studenteService = studenteService;
    }

    @GetMapping(value = "/studenti")
    public ResponseEntity<List<StudenteDTO>> allStudents(){
        List<StudenteDTO> list = studenteService.listOfStudenti();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/studenti-after/{matricola}")
    public ResponseEntity<List<StudenteDTO>> allStudentsAfterMatricola(@PathVariable Integer matricola){
        List<StudenteDTO> list = studenteService.listOfStudentiAfterMatricola(matricola);
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/studenti-after-datanascita/{date}")
    public ResponseEntity<List<StudenteDTO>> allStudentsAfterMatricola(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date){
        List<StudenteDTO> list = studenteService.listOfStudentiAfterDataNascita(date);
        return ResponseEntity.ok().body(list);
    }


    @PostMapping(value = "/create-studente", consumes = "application/json")
    public ResponseEntity<StudenteDTO> createStudente(@RequestBody StudenteDTO studenteDTO){
        studenteService.saveStudente(studenteDTO);
        return ResponseEntity.ok().body(studenteDTO);
    }

    @PutMapping(value = "/update-studente/{matricola}", consumes = "application/json")
    public ResponseEntity<StudenteDTO> updateStudente(@PathVariable Integer matricola, @RequestBody StudenteDTO studenteDTO){
        studenteService.updateStudente(studenteDTO, matricola);
        return ResponseEntity.ok().body(studenteDTO);
    }

    @PutMapping(value = "/update-studente-attivo/{matricola}", consumes = "application/json")
    public ResponseEntity<String> attivaStudente(@PathVariable Integer matricola, @RequestBody Integer corsoDiLaurea){
        try {
            studenteService.attivaStudente(matricola, corsoDiLaurea);
        } catch (Exception e) {
            System.out.println("Lanciata eccezione: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
        return ResponseEntity.ok().body("Studente + " + matricola + " attivato.");
    }

    @PutMapping(value = "/update-studente-laureato/{matricola}", consumes = "application/json")
    public ResponseEntity<String> laureaStudente(@PathVariable Integer matricola){
        studenteService.laureaStudente(matricola);
        return ResponseEntity.ok().body("Studente + " + matricola + " attivato.");
    }

    @DeleteMapping(value = "/delete-studente/{matricola}")
    public ResponseEntity<String> deleteStudente(@PathVariable Integer matricola){
        try {
            studenteService.deleteStudente(matricola);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.badRequest().body("Errore nel server.");
        }
        return ResponseEntity.ok().body("Studente " + matricola + " eliminato. ");
    }

}
