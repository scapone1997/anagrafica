package universita.anagrafica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import universita.anagrafica.domain.EdizioneCorso;


@Repository
public interface EdizioneCorsoRepository extends JpaRepository<EdizioneCorso, Integer> {

    @Query(value = "SELECT * FROM edizione_corso ec WHERE id = (SELECT e.id FROM edizione_corso e, corso c WHERE e.corso = c.id and c.nome = :nomeCorso AND e.anno_accademico = :annoAccademico)", nativeQuery = true)
    EdizioneCorso edizioneCorsoPerNomeAndAnnoAccademico(@Param("nomeCorso") String nomeCorso, @Param("annoAccademico") String annoAccademico);

}
