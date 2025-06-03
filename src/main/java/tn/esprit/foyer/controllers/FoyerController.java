package tn.esprit.foyer.controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.foyer.models.Foyer;
import tn.esprit.foyer.services.FoyerService;

@Tag(name = "Gestion Foyers")
@RestController
@RequestMapping("/Foyers")
@AllArgsConstructor
public class FoyerController {
    private final FoyerService foyerService;
    @PostMapping("/AjouterFoyerAvecBlocs")
    public Foyer ajouterFoyer(@RequestBody Foyer foyer) {
        return foyerService.ajouterFoyerAvecBlocsAssociés(foyer);
    }
}
