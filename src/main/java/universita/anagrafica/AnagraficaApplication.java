package universita.anagrafica;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import universita.anagrafica.domain.Studente;
import universita.anagrafica.dto.StudenteDTO;
import universita.anagrafica.mapper.StudenteMapper;
import universita.anagrafica.mapper.StudenteMapperImpl;

@SpringBootApplication
public class AnagraficaApplication {

	public static void main(String[] args) {

		SpringApplication.run(AnagraficaApplication.class, args);
	}

}
