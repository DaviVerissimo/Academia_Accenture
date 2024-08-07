package acc.br.CorridaJPA.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import acc.br.CorridaJPA.model.Local;

@Repository
public interface LocalRepository extends JpaRepository<Local, Long> {
}
