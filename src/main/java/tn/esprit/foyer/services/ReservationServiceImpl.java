package tn.esprit.foyer.services;

import org.springframework.stereotype.Service;
import tn.esprit.foyer.models.Reservation;
import tn.esprit.foyer.repositories.ReservationRepository;

@Service
public class ReservationServiceImpl implements ReservationService{
    private final ReservationRepository reservationRepository;

    public ReservationServiceImpl(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;

    }

    @Override
    public Reservation ajouterReservationAvecEtudiants(Reservation reservation) {
        return reservationRepository.save(reservation) ;
    }
}
