package tn.esprit.foyer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.foyer.models.Universite;

@Repository

public interface UniversiteRepository extends JpaRepository<Universite,Long> {
}
