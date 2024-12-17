
package com.gestion.vols.services;

import com.gestion.vols.entities.Plane;
import com.gestion.vols.repositories.PlaneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlaneService {

    @Autowired
    private PlaneRepository planeRepository;

    // Fetch all planes
    public List<Plane> getAllPlanes() {
        return planeRepository.findAll();
    }

    // Fetch a plane by ID
    public Optional<Plane> getPlaneById(Long id) {
        return planeRepository.findById(id);
    }

    // Save a new plane
    public Plane savePlane(Plane plane) {
        return planeRepository.save(plane);
    }

    // Delete a plane by ID
    public void deletePlane(Long id) {
        planeRepository.deleteById(id);
    }

	public Plane updatePlane(Long id, Plane planeDetails) {
		// TODO Auto-generated method stub
		return null;
	}
}
