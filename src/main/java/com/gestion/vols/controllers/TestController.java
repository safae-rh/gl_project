
package com.gestion.vols.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/test")
public class TestController {

    // Accès réservé uniquement aux utilisateurs avec le rôle ADMIN
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/admin")
    public String adminAccess() {
        return "Contenu réservé à l'admin.";
    }

    // Accès réservé aux utilisateurs ayant le rôle USER ou ADMIN
    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
    @GetMapping("/user")
    public String userAccess() {
        return "Contenu réservé à l'utilisateur ou à l'admin.";
    }
}
