package universita.anagrafica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import universita.anagrafica.domain.Studente;

@Repository
public interface StudenteRepository extends JpaRepository<Studente, Integer> {
}
