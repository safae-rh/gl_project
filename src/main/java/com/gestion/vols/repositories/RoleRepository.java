
package com.gestion.vols.repositories;

import com.gestion.vols.entities.ERole;
import com.gestion.vols.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole roleUser);  // Trouver un rôle par son nom
    boolean existsByName(ERole name);
	
}
