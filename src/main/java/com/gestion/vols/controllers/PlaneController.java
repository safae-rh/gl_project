
package com.gestion.vols.controllers;

import com.gestion.vols.entities.Plane;
import com.gestion.vols.services.PlaneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/planes")
public class PlaneController {

    @Autowired
    private PlaneService planeService;

    // Get all planes
    @GetMapping
    public List<Plane> getAllPlanes() {
        return planeService.getAllPlanes();
    }

    // Get a specific plane by ID
    @GetMapping("/{id}")
    public ResponseEntity<Plane> getPlaneById(@PathVariable Long id) {
        Optional<Plane> plane = planeService.getPlaneById(id);
        return plane.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Create a new plane
    @PostMapping
    public Plane createPlane(@RequestBody Plane plane) {
        return planeService.savePlane(plane);
    }

    // Update an existing plane
    @PutMapping("/{id}")
    public ResponseEntity<Plane> updatePlane(@PathVariable Long id, @RequestBody Plane planeDetails) {
        try {
            Plane updatedPlane = planeService.updatePlane(id, planeDetails);
            return ResponseEntity.ok(updatedPlane);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete a plane
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlane(@PathVariable Long id) {
        try {
            planeService.deletePlane(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
