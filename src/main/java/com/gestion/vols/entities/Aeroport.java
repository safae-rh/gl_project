package com.gestion.vols.entities;



import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "aeroports") // Nom de la table dans la base de données
public class Aeroport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // ID auto-généré
    private Long id;

    @Column(nullable = false, unique = true)
    private String codeIATA; // Code IATA unique pour l'aéroport (exemple : JFK, CDG)

    @Column(nullable = false)
    private String nom; // Nom de l'aéroport (exemple : Aéroport Charles de Gaulle)

    @Column(nullable = false)
    private String ville; // Ville où se trouve l'aéroport (exemple : Paris)

    @Column(nullable = false)
    private String pays; // Pays où se trouve l'aéroport (exemple : France)

    @Column(nullable = false)
    private int capacite; // Capacité maximale de l'aéroport en termes de trafic

    // Association avec les vols départs
    @OneToMany(mappedBy = "aeroportDepart", cascade = CascadeType.ALL, orphanRemoval = true)
    private java.util.List<Vol> volsDepart;

    // Association avec les vols arrivées
    @OneToMany(mappedBy = "aeroportArrivee", cascade = CascadeType.ALL, orphanRemoval = true)
    private java.util.List<Vol> volsArrivee;

	public Object getName() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getLocation() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setName(Object name) {
		// TODO Auto-generated method stub
		
	}

	public void setLocation(Object location) {
		// TODO Auto-generated method stub
		
	}
}
