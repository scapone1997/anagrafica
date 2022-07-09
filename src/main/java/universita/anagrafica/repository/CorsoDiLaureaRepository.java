package universita.anagrafica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import universita.anagrafica.domain.CorsoDiLaurea;

@Repository
public interface CorsoDiLaureaRepository extends JpaRepository<CorsoDiLaurea, Integer> {
}
