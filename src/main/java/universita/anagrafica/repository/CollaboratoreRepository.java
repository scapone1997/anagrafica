package universita.anagrafica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import universita.anagrafica.mapper.domain.Collaboratore;

@Repository
public interface CollaboratoreRepository extends JpaRepository<Collaboratore, Integer> {
}
