package tn.esprit.foyer.repositories;

import org.springdoc.core.converters.models.PageableAsQueryParam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.foyer.models.Chambre;
import tn.esprit.foyer.models.TypeChambre;

import java.util.List;
@Repository
public interface ChambreRepository extends JpaRepository<Chambre,Long> {
   /* List<Chambre> findAllByTypeC(TypeChambre typeChambre);

    Chambre findChambreByNumeroChambre(Long numeroChambre);
    List<Chambre> findAllByBlocIdBloc(Long blocId);*/
   @Query("SELECT c FROM Chambre c WHERE c.typeC = :typeChambre")
   List<Chambre> findAllByTypeC(@Param("typeChambre") TypeChambre typeChambre);

    @Query("SELECT c FROM Chambre c WHERE c.numeroChambre = :numero")
    Chambre findChambreByNumeroChambre(@Param("numero") Long numero);

    @Query("SELECT c FROM Chambre c WHERE c.bloc.idBloc = :blocId")
    List<Chambre> findAllByBlocIdBloc(@Param("blocId") Long blocId);

}
