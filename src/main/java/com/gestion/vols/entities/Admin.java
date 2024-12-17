package com.gestion.vols.entities;



import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String email;

    @Column
    private String password;

    @Column
    private String nomComplet;

    @Column
    private String idAdmin;

	public Object getEmail() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setEmail(Object email2) {
		// TODO Auto-generated method stub
		
	}

	public Object getPassword() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setPassword(Object password2) {
		// TODO Auto-generated method stub
		
	}

	public Object getNomComplet() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setNomComplet(Object nomComplet2) {
		// TODO Auto-generated method stub
		
	}

	public Object getIdAdmin() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setIdAdmin(Object idAdmin2) {
		// TODO Auto-generated method stub
		
	}

    // Constructeur, getters, setters, etc. sont générés par Lombok (@Data)
}
