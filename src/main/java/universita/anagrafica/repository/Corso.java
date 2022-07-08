package universita.anagrafica.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.criteria.CriteriaBuilder;

public interface Corso extends JpaRepository<Corso, CriteriaBuilder.In> {
}
