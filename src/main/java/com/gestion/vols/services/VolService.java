package com.gestion.vols.services;

import com.gestion.vols.entities.Vol;
import com.gestion.vols.repositories.VolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VolService {

    private VolRepository volRepository;

    public Vol createVol(Vol vol) {
        return volRepository.save(vol);
    }

    public Vol updateVol(Long id, Vol volDetails) {
        Optional<Vol> vol = volRepository.findById(id);
        if (vol.isPresent()) {
            Vol existingVol = vol.get();
            existingVol.setNumeroVol(volDetails.getNumeroVol());
            existingVol.setTempsDepart(volDetails.getTempsDepart());
            existingVol.setTempsArrivee(volDetails.getTempsArrivee());
            existingVol.setAeroportDepart(volDetails.getAeroportDepart());
            existingVol.setAeroportArrivee(volDetails.getAeroportArrivee());
            existingVol.setCompagnieAerienne(volDetails.getCompagnieAerienne());
            // Mettre à jour d'autres champs si nécessaire
            return volRepository.save(existingVol);
        } else {
            // Gestion des erreurs si le vol n'existe pas
            throw new RuntimeException("Vol non trouvé avec l'ID : " + id);
        }
    }

    // Supprimer un vol
    public void deleteVol(Long id) {
        Optional<Vol> vol = volRepository.findById(id);
        if (vol.isPresent()) {
            volRepository.delete(vol.get());
        } else {
            // Gestion des erreurs si le vol n'existe pas
            throw new RuntimeException("Vol non trouvé avec l'ID : " + id);
        }
    }

    // Récupérer tous les vols
    public List<Vol> getAllVols() {
        return volRepository.findAll();
    }

    // Récupérer un vol par son ID
    public Vol getVolById(Long id) {
        Optional<Vol> vol = volRepository.findById(id);
        if (vol.isPresent()) {
            return vol.get();
        } else {
            // Gestion des erreurs si le vol n'existe pas
            throw new RuntimeException("Vol non trouvé avec l'ID : " + id);
        }
    }

    // Récupérer des vols par l'aéroport de départ
    public List<Vol> getVolsByAeroportDepart(String aeroportDepart) {
        return volRepository.findByAeroportDepart(aeroportDepart);
    }

    // Récupérer des vols par l'aéroport d'arrivée
    public List<Vol> getVolsByAeroportArrivee(String aeroportArrivee) {
        return volRepository.findByAeroportArrivee(aeroportArrivee);
    }

	public Vol saveVol(Vol vol) {
		// TODO Auto-generated method stub
		return null;
	}
}
