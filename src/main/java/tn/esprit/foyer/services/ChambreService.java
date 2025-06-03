package tn.esprit.foyer.services;

import tn.esprit.foyer.models.Chambre;
import tn.esprit.foyer.models.TypeChambre;

import java.util.List;

public interface ChambreService {
   Chambre saveChambre(Chambre chambre);
   void deleteChambre(Long idChambre);
   Chambre getChambreById(Long idChambre);


   List<Chambre> getAllChambres();
   List<Chambre> getChambreParTypeChambre(TypeChambre typeChambre);
   Chambre findChambreByNumeroChambre(Long numeroChambre);
   List<Chambre>findAllByBlocIdBloc(Long blocIdBloc);
}
