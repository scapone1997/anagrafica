package universita.anagrafica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import universita.anagrafica.mapper.domain.Studente;

import java.time.LocalDate;
import java.util.Collection;

@Repository
public interface StudenteRepository extends JpaRepository<Studente, Integer> {

    @Query(value = "SELECT * FROM studente S WHERE S.MATRICOLA > :matricola", nativeQuery = true)
    Collection<Studente> findStudentAfterMatricola(@Param("matricola") Integer matricola);

    @Query(value = "SELECT * FROM studente S WHERE S.DATA_NASCITA > :date", nativeQuery = true)
    Collection<Studente> findStudenteAfterDataNascita(@Param("date") LocalDate date);
}
