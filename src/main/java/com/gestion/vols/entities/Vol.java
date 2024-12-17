
package com.gestion.vols.entities;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "vols") // Nom de la table dans la base de données
public class Vol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // ID auto-généré
    private Long id;

    // Relation avec l'utilisateur qui a réservé ou est responsable du vol
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    // Relation avec le membre du personnel qui gère le vol
    @ManyToOne
    @JoinColumn(name = "staff_id")
    private Staff staff;

    @Column(nullable = false, unique = true)
    private String numeroVol;

    @Column(nullable = false)
    private String aeroportDepart;

    @Column(nullable = false)
    private String aeroportArrivee;

    @Column(nullable = false)
    private LocalDateTime dateDepart;

    @Column(nullable = false)
    private LocalDateTime dateArrivee;

    @Column(nullable = false)
    private String statut; // Exemple : "En cours", "Terminé", etc.

    // Association avec Avion
    @ManyToOne
    @JoinColumn(name = "avion_id", nullable = false)
    private Plane plane;

    // Association avec les membres d'équipage
    @ManyToMany
    @JoinTable(
        name = "vol_membres_equipage",
        joinColumns = @JoinColumn(name = "vol_id"),
        inverseJoinColumns = @JoinColumn(name = "membre_equipage_id")
    )
    private List<MembreEquipage> membresEquipage;

    // Association avec les réservations
    @OneToMany(mappedBy = "vol", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Reservation> reservations;

	public Object getNumeroVol() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getCompagnieAerienne() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setCompagnieAerienne(Object compagnieAerienne) {
		// TODO Auto-generated method stub
		
	}

	public Object getAeroportArrivee() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setAeroportArrivee(Object aeroportArrivee2) {
		// TODO Auto-generated method stub
		
	}

	public Object getAeroportDepart() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setAeroportDepart(Object aeroportDepart2) {
		// TODO Auto-generated method stub
		
	}

	public Object getTempsArrivee() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setTempsArrivee(Object tempsArrivee) {
		// TODO Auto-generated method stub
		
	}

	public Object getTempsDepart() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setTempsDepart(Object tempsDepart) {
		// TODO Auto-generated method stub
		
	}

	public void setNumeroVol(Object numeroVol2) {
		// TODO Auto-generated method stub
		
	}
}
