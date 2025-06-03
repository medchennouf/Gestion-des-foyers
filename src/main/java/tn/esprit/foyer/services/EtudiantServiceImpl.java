package tn.esprit.foyer.services;

import org.springframework.stereotype.Service;
import tn.esprit.foyer.models.Chambre;
import tn.esprit.foyer.models.Etudiant;
import tn.esprit.foyer.repositories.ChambreRepository;
import tn.esprit.foyer.repositories.EtudiantRepository;

import java.util.List;

@Service
public class EtudiantServiceImpl implements EtudiantService {
    private final EtudiantRepository etudiantRepository;
    public EtudiantServiceImpl(EtudiantRepository etudiantRepository) {
        this.etudiantRepository = etudiantRepository;
    }

    @Override
    public Etudiant saveEtudiant (Etudiant etudiant) {
        return etudiantRepository.save(etudiant) ;
    }

    @Override
    public void deleteEtudiant(Long id) {
        etudiantRepository.deleteById(id);
    }

    @Override
    public Etudiant getEtudiantById(Long idEtudiant) {
        return etudiantRepository.findById(idEtudiant).get();
    }


    @Override
    public List<Etudiant> getAllEtudiants() {
        return etudiantRepository.findAll();
    }
}
