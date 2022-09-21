package universita.anagrafica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import universita.anagrafica.domain.TassaStudente;

@Repository
public interface TassaStudenteRepository extends JpaRepository<TassaStudente, Integer> {
}
