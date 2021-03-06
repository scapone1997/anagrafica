package universita.anagrafica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import universita.anagrafica.domain.Corso;


@Repository
public interface CorsoRepository extends JpaRepository<Corso, Integer> {

}
