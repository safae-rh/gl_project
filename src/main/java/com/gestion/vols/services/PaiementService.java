
package com.gestion.vols.services;

import com.gestion.vols.entities.Paiement;
import com.gestion.vols.repositories.PaiementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaiementService {

    @Autowired
    private PaiementRepository paymentRepository;

    // Fetch all payments
    public List<Paiement> getAllPayments() {
        return paymentRepository.findAll();
    }

    // Fetch a payment by ID
    public Optional<Paiement> getPaymentById(Long id) {
        return paymentRepository.findById(id);
    }

    // Save a new payment
    public Paiement savePayment(Paiement paiement) {
        return paymentRepository.save(paiement);
    }

    // Delete a payment by ID
    public void deletePayment(Long id) {
        paymentRepository.deleteById(id);
    }

	public static Paiement updatePaiement(Long id, Paiement paymentDetails) {
		// TODO Auto-generated method stub
		return null;
	}
}
