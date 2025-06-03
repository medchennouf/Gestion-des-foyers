package tn.esprit.foyer.controllers;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.foyer.models.Chambre;
import tn.esprit.foyer.models.TypeChambre;
import tn.esprit.foyer.services.ChambreService;
import tn.esprit.foyer.services.ChambreServiceImpl;

import java.util.List;
@Tag(name ="chambre-controller")

@RestController
@RequestMapping("/chambres")
public class ChambreController {
    @Autowired
    ChambreService chambreService;
    @Autowired
    private ChambreServiceImpl chambreServiceImpl;

    @PostMapping("/ajouterChambre")
    public Chambre createChambre(@RequestBody Chambre chambre) {
        return chambreService.saveChambre(chambre);
    }
    @DeleteMapping("/deleteChambre/{id}")
    public void deleteChambre(@PathVariable Long id) {
        chambreService.deleteChambre(id);
    }
    @Operation(description = "recuperer les chambres byId")
    @GetMapping("/getById/{id}")
    public Chambre getChambreById(@PathVariable Long id) {
        return chambreService.getChambreById(id);
    }
    @GetMapping
    public List<Chambre> getAllChambres() {
        return chambreService.getAllChambres();
    }
    @GetMapping("/type/{typeChambre}")
    public List<Chambre> getChambreByType(@PathVariable TypeChambre typeChambre) {
        return chambreServiceImpl.getChambreParTypeChambre(typeChambre);
    }
    @GetMapping("/Numero/{NumeroChambre}")
    public Chambre getChambreByNumero(@PathVariable Long NumeroChambre) {
        return chambreServiceImpl.findChambreByNumeroChambre(NumeroChambre);
    }
    @GetMapping("/BlocId/{blocId}")
    public List<Chambre> getChambreByBlocId(@PathVariable Long blocId) {
        return chambreServiceImpl.findAllByBlocIdBloc(blocId);
    }

}
