package universita.anagrafica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import universita.anagrafica.domain.CorsoDiLaurea;

import java.util.Optional;

@Repository
public interface CorsoDiLaureaRepository extends JpaRepository<CorsoDiLaurea, Integer> {
    Optional<CorsoDiLaurea> findById(Integer id);

    Optional<CorsoDiLaurea> findByNome(String corsoDiLaurea);
}