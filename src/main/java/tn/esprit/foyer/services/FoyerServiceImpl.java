package tn.esprit.foyer.services;

import org.springframework.stereotype.Service;
import tn.esprit.foyer.models.Foyer;
import tn.esprit.foyer.repositories.FoyerRepository;
@Service
public class FoyerServiceImpl implements FoyerService {
    private final FoyerRepository foyerRepository;

    public FoyerServiceImpl(FoyerRepository foyerRepository) {
        this.foyerRepository = foyerRepository;
    }

    @Override
    public Foyer ajouterFoyerAvecBlocsAssociés(Foyer foyer) {
        return foyerRepository.save(foyer);
    }
}
