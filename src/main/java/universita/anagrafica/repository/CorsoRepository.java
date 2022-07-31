package universita.anagrafica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import universita.anagrafica.domain.Corso;
import universita.anagrafica.domain.CorsoDiLaurea;

import java.util.List;


@Repository
public interface CorsoRepository extends JpaRepository<Corso, Integer> {

    List<Corso> findByCorsoDiLaureaAndObbligatorio(CorsoDiLaurea corsoDiLaurea, Boolean bool);
}
