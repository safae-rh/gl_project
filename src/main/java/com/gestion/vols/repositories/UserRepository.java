
package com.gestion.vols.repositories;

import com.gestion.vols.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username); // Trouver un utilisateur par son nom d'utilisateur
    Boolean existsByUsername(String username); // Vérifier si un utilisateur avec ce nom d'utilisateur existe
    Optional<User> findByEmail(String email); // Trouver un utilisateur par son email
}
