package tn.esprit.foyer.services;

import tn.esprit.foyer.models.Chambre;
import tn.esprit.foyer.models.Etudiant;

import java.util.List;

public interface EtudiantService {
   Etudiant saveEtudiant(Etudiant et);
    void deleteEtudiant(Long id);
   Etudiant getEtudiantById(Long id);


    List<Etudiant> getAllEtudiants();
}
