
package com.gestion.vols.controllers;

import com.gestion.vols.entities.Aeroport;
import com.gestion.vols.services.AeroportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/aeroports")
public class AeroportController {

    @Autowired
    private AeroportService aeroportService;

    // Get all aeroports
    @GetMapping
    public List<Aeroport> getAllAeroports() {
        return aeroportService.getAllAeroports();
    }

    // Get a specific aeroport by ID
    @GetMapping("/{id}")
    public ResponseEntity<Aeroport> getAeroportById(@PathVariable Long id) {
        Optional<Aeroport> aeroport = aeroportService.getAeroportById(id);
        return aeroport.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Create a new aeroport
    @PostMapping
    public Aeroport createAeroport(@RequestBody Aeroport aeroport) {
        return aeroportService.saveAeroport(aeroport);
    }

    // Update an existing aeroport
    @PutMapping("/{id}")
    public ResponseEntity<Aeroport> updateAeroport(@PathVariable Long id, @RequestBody Aeroport aeroportDetails) {
        try {
            Aeroport updatedAeroport = aeroportService.updateAeroport(id, aeroportDetails);
            return ResponseEntity.ok(updatedAeroport);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete an aeroport
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAeroport(@PathVariable Long id) {
        try {
            aeroportService.deleteAeroport(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
