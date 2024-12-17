package com.gestion.vols.entities;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "membres_equipage") // Nom de la table dans la base de données
public class MembreEquipage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // ID auto-généré
    private Long id;

    @Column(nullable = false)
    private String nomComplet; // Nom complet du membre de l'équipage

    @Column(nullable = false)
    private String fonction; // Fonction du membre de l'équipage (ex. : Pilote, Hôtesse)

    @Column(nullable = false, unique = true)
    private String numLicence; // Numéro de licence unique pour chaque membre

    @Column(nullable = false)
    private String nationalite; // Nationalité du membre de l'équipage

    // Relation avec Vol : plusieurs membres de l'équipage peuvent être associés à un vol
    @ManyToOne
    @JoinColumn(name = "vol_id", nullable = false) // Clé étrangère vers la table Vol
    private Vol vol;
}
