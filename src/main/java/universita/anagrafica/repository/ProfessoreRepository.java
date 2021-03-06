package universita.anagrafica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import universita.anagrafica.domain.Professore;

@Repository
public interface ProfessoreRepository extends JpaRepository<Professore, Integer> {
}
