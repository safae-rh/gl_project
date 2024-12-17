package com.gestion.vols.initializer;

import com.gestion.vols.entities.ERole;
import com.gestion.vols.entities.Role;
import com.gestion.vols.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class RoleInitializer implements CommandLineRunner {
    @Autowired
    RoleRepository roleRepository;

    @Override
    public void run(String... args) throws Exception {
        // Vérifier si le rôle ROLE_USER existe, sinon l'ajouter
        if (roleRepository.existsByName(ERole.ROLE_USER)) {
            roleRepository.save(new Role(ERole.ROLE_USER));
        }

        // Vérifier si le rôle ROLE_ADMIN existe, sinon l'ajouter
        if (roleRepository.existsByName(ERole.ROLE_ADMIN)) {
            roleRepository.save(new Role(ERole.ROLE_ADMIN));
        }
    }
}
