package universita.anagrafica;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages = "universita.anagrafica.client")
public class AnagraficaApplication {

	public static void main(String[] args) {

		SpringApplication.run(AnagraficaApplication.class, args);
	}

}
