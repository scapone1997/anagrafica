package universita.anagrafica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import universita.anagrafica.domain.Corso;

import java.util.List;


@Repository
public interface CorsoRepository extends JpaRepository<Corso, Integer> {

    List<Corso> findByCorsoDiLaurea(Integer corsoDiLaurea);
}
