
package com.gestion.vols.services;

import com.gestion.vols.entities.Aeroport;
import com.gestion.vols.repositories.AeroportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AeroportService {

    private AeroportRepository aeroportRepository;

    // Fetch all airports
    public List<Aeroport> getAllAeroports() {
        return aeroportRepository.findAll();
    }

    // Fetch an airport by ID
    public Optional<Aeroport> getAeroportById(Long id) {
        return aeroportRepository.findById(id);
    }

    // Save a new airport
    public Aeroport saveAeroport(Aeroport aeroport) {
        return aeroportRepository.save(aeroport);
    }

    // Update an existing airport
    public Aeroport updateAeroport(Long id, Aeroport aeroportDetails) {
        return aeroportRepository.findById(id)
                .map(aeroport -> {
                    aeroport.setName(aeroportDetails.getName());
                    aeroport.setLocation(aeroportDetails.getLocation());
                    return aeroportRepository.save(aeroport);
                })
                .orElseThrow(() -> new RuntimeException("Aeroport not found with id " + id));
    }

    // Delete an airport by ID
    public void deleteAeroport(Long id) {
        aeroportRepository.deleteById(id);
    }

	public List<Aeroport> getAllAeroports1() {
		// TODO Auto-generated method stub
		return null;
	}
}
