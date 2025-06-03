package tn.esprit.foyer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.foyer.models.Foyer;

@Repository

public interface FoyerRepository extends JpaRepository<Foyer,Long> {
}
