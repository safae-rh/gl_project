
package com.gestion.vols.services;

import com.gestion.vols.entities.Reservation;
import com.gestion.vols.repositories.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    // Fetch all reservations
    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    // Fetch a reservation by ID
    public Optional<Reservation> getReservationById(Long id) {
        return reservationRepository.findById(id);
    }

    // Save a new reservation
    public Reservation saveReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    // Delete a reservation by ID
    public void deleteReservation(Long id) {
        reservationRepository.deleteById(id);
    }

	public Reservation updateReservation(Long id, Reservation reservationDetails) {
		// TODO Auto-generated method stub
		return null;
	}
}
