package com.gestion.vols.payload.response;



import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class JwtResponse {

    private String token;
    private String type = "Bearer";
    private Long id;
    private String nomComplet;
    private String email;
    private String role;

    // Champs spécifiques pour les Passagers
    private String numPasseport;
    private String telephone;

    public JwtResponse(String accessToken, Long id, String nomComplet, String email, String role, String numPasseport, String telephone) {
        this.token = accessToken;
        this.id = id;
        this.nomComplet = nomComplet;
        this.email = email;
        this.role = role;
        this.numPasseport = numPasseport;
        this.telephone = telephone;
    }

	public JwtResponse(String jwt, Long id2, String username, Set<String> roles) {
		// TODO Auto-generated constructor stub
	}
}
