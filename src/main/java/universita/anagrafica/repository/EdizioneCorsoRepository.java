package universita.anagrafica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import universita.anagrafica.domain.EdizioneCorso;


@Repository
public interface EdizioneCorsoRepository extends JpaRepository<EdizioneCorso, Integer> {
}
