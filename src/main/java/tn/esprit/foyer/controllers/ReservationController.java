package tn.esprit.foyer.controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.foyer.models.Reservation;
import tn.esprit.foyer.services.ReservationService;

@Tag(name = "Gestion Reservations")
@RestController
@RequestMapping("/reservations")
@AllArgsConstructor
public class ReservationController {
    private final ReservationService reservationService;
    @PostMapping("/ajouterReservationAvecEtudiants")
    public Reservation ajouterReservationAvecEtudiants(@RequestBody Reservation reservation) {
        return reservationService.ajouterReservationAvecEtudiants(reservation);
    }
}
