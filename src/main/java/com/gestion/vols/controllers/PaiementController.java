
package com.gestion.vols.controllers;

import com.gestion.vols.entities.Paiement;
import com.gestion.vols.services.PaiementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/payments")
public class PaiementController {

    @Autowired
    private PaiementService paymentService;

    // Get all payments
    @GetMapping
    public List<Paiement> getAllPayments() {
        return paymentService.getAllPayments();
    }

    // Get a specific payment by ID
    @GetMapping("/{id}")
    public ResponseEntity<Paiement> getPaymentById(@PathVariable Long id) {
        Optional<Paiement> payment = paymentService.getPaymentById(id);
        return payment.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Create a new payment
    @PostMapping
    public Paiement createPayment(@RequestBody Paiement payment) {
        return paymentService.savePayment(payment);
    }

    // Update an existing payment
    @PutMapping("/{id}")
    public ResponseEntity<Paiement> updatePayment(@PathVariable Long id, @RequestBody Paiement paymentDetails) {
        try {
            Paiement updatedPayment = PaiementService.updatePaiement(id, paymentDetails);
            return ResponseEntity.ok(updatedPayment);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete a payment
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePayment(@PathVariable Long id) {
        try {
            paymentService.deletePayment(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
