package com.gestion.vols.entities;




import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "passagers") // Nom de la table dans la base de données
public class Passager {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // ID auto-généré
    private Long id;

    @Column(nullable = false, unique = true)
    private String numPasseport; // Numéro de passeport unique du passager

    @Column(nullable = false)
    private String numCarteIdentite; // Numéro de carte d'identité

    @Column(nullable = false)
    private String nomComplet; // Nom complet du passager

    @Column(nullable = false)
    private String nationalite; // Nationalité du passager

    @Column(nullable = false)
    private String adresse; // Adresse du passager

    @Column(nullable = false)
    private String telephone; // Numéro de téléphone du passager

    // Relation avec Reservation : Un passager peut avoir plusieurs réservations
    @OneToMany(mappedBy = "passager", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Reservation> reservations; // Liste des réservations effectuées par le passager
}
