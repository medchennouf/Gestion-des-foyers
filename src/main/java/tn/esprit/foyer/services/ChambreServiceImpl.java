package tn.esprit.foyer.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.foyer.models.Chambre;
import tn.esprit.foyer.models.TypeChambre;
import tn.esprit.foyer.repositories.ChambreRepository;
import java.util.Calendar;


import java.util.List;
@Slf4j
@Service
public class ChambreServiceImpl implements ChambreService {
   //Type1
    // @Autowired
  //  ChambreRepository chambreRepository;
    //Type2
    private final ChambreRepository chambreRepository;
    //type3
    //void setChambreRepository(ChambreRepository chambreRepository) {}


    public ChambreServiceImpl(ChambreRepository chambreRepository) {
        this.chambreRepository = chambreRepository;
    }

    @Override
    public Chambre saveChambre(Chambre chambre) {
        return chambreRepository.save(chambre) ;
    }

    @Override
    public void deleteChambre(Long idChambre) {
    chambreRepository.deleteById(idChambre);
    }

    @Override
    public Chambre getChambreById(Long idChambre) {
        return chambreRepository.findById(idChambre).get();
    }


    @Override
    public List<Chambre> getAllChambres() {
        return chambreRepository.findAll();

    }

    public List<Chambre> getChambreParTypeChambre(TypeChambre typeChambre){
        return chambreRepository.findAllByTypeC(typeChambre);
    }
    public Chambre findChambreByNumeroChambre(Long numeroChambre){
        return chambreRepository.findChambreByNumeroChambre(numeroChambre);
    }
    public List<Chambre>findAllByBlocIdBloc(Long blocIdBloc){
        return chambreRepository.findAllByBlocIdBloc(blocIdBloc);
    }
    @Scheduled(fixedDelay = 60000)
    public void fixedDelayMethod() {
        log.info("Method with fixed delay");
    }
    @Scheduled(fixedRate = 60000)
    public void fixedRateMethod() {
        log.info("Method with fixed Rate");
    }
    @Scheduled(cron = "0 * * * * *")
    public void listerChambresParBloc() {
        log.info("Liste des chambres par bloc :");
        List<Chambre> chambres = chambreRepository.findAll();

        for (Chambre chambre : chambres) {
            String blocNom = "inconnu";
            if (chambre.getBloc() != null) {
                blocNom = chambre.getBloc().getNomBloc();
            }

            log.info("-> Bloc " + blocNom +
                    " - Chambre " + chambre.getNumeroChambre() +
                    " (" + chambre.getTypeC() + ")");
        }
    }
    @Scheduled(cron = "0 */5 * * * *")
    public void pourcentageChambreParTypeChambre() {
        List<Chambre> chambres = chambreRepository.findAll();
        int total = chambres.size();

        log.info("---");
        log.info("Nombre total des chambre: " + total);

        if (total == 0) {
            log.info("Aucune chambre enregistrée.");
            return;
        }

        for (TypeChambre type : TypeChambre.values()) {
            long count = chambres.stream().filter(c -> c.getTypeC() == type).count();
            double pourcentage = (count * 100.0) / total;
            log.info("Le pourcentage des chambres pour le type " + type + " est égale à " + pourcentage);
        }
    }
    @Scheduled(cron = "0 */5 * * * *")
    public void nbPlacesDisponibleParChambreAnneeEnCours() {
        List<Chambre> chambres = chambreRepository.findAll();

        int anneeEnCours = 2025;

        for (Chambre chambre : chambres) {
            int capacite = switch (chambre.getTypeC()) {
                case SIMPLE -> 1;
                case DOUBLE -> 2;
                case TRIPLE -> 3;
            };

            long nbRes = chambre.getReservations().stream()
                    .filter(r -> {
                        Calendar cal = Calendar.getInstance();
                        cal.setTime(r.getAnneeUniversitaire());
                        int annee = cal.get(Calendar.YEAR);
                        return annee == anneeEnCours;
                    })
                    .count();


            int placesDispo = capacite - (int) nbRes;

            if (placesDispo <= 0) {
                log.info("La chambre " + chambre.getTypeC() + " " + chambre.getNumeroChambre() + " est complete");
            } else {
                log.info("Le nombre de place disponible pour la chambre " + chambre.getTypeC() + " " + chambre.getNumeroChambre() + " est " + placesDispo);
            }
        }
    }


}
