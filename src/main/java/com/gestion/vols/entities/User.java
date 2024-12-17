package com.gestion.vols.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;

@Data
@Entity
@Table(name = "users") // Nom de la table dans la base de données
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // ID auto-généré
    private Long id;
    @Column(name = "user_name")
    private String username;

    @Column(nullable = false, unique = true)
    private String email; // Email de l'utilisateur, unique

    @Column(nullable = false)
    private String password; // Mot de passe de l'utilisateur (crypté)

    @Column(nullable = false)
    private String nomComplet; // Nom complet de l'utilisateur

    // Rôles associés à l'utilisateur
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_roles", // Table de liaison
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles = new HashSet<>();

	public static Object builder() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getUsername() {
		// TODO Auto-generated method stub
		return null;
	}

	public Collection<? extends GrantedAuthority> getRoles() {
		// TODO Auto-generated method stub
		return null;
	}

	public Long getId() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getPassword() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setUsername(String username) {
		// TODO Auto-generated method stub
		
	}

	public void setPassword(String encode) {
		// TODO Auto-generated method stub
		
	}
	


	public void setRoles(Set<Role> roles2) {
		// TODO Auto-generated method stub
		
	}
}
