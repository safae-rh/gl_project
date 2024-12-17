
package com.gestion.vols.controllers;

import com.gestion.vols.entities.Vol;
import com.gestion.vols.services.VolService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/vols")
@RequiredArgsConstructor
public class VolController {

    private final VolService volService;

    // Get all vols
    @GetMapping
    public List<Vol> getAllVols() {
        return volService.getAllVols();
    }

    // Get a specific vol by ID
    @GetMapping("/{id}")
    public ResponseEntity<Vol> getVolById(@PathVariable Long id) {
        Optional<Vol> vol = Optional.ofNullable(volService.getVolById(id));
        return vol.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Create a new vol
    @PostMapping
    public Vol createVol(@RequestBody Vol vol) {
        return volService.saveVol(vol);
    }

    // Update an existing vol
    @PutMapping("/{id}")
    public ResponseEntity<Vol> updateVol(@PathVariable Long id, @RequestBody Vol volDetails) {
        try {
            Vol updatedVol = volService.updateVol(id, volDetails);
            return ResponseEntity.ok(updatedVol);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete a vol
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVol(@PathVariable Long id) {
        try {
            volService.deleteVol(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
