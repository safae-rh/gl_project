package com.gestion.vols.services;

import com.gestion.vols.entities.User;
import com.gestion.vols.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    /**
     * Méthode qui charge un utilisateur en fonction du nom d'utilisateur.
     *
     * @param username Le nom d'utilisateur à rechercher
     * @return L'utilisateur trouvé avec ses détails
     * @throws UsernameNotFoundException Si l'utilisateur n'est pas trouvé
     */
    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Recherche de l'utilisateur dans la base de données
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Utilisateur introuvable avec le nom : " + username));

        // Retourne un objet UserDetailsImpl basé sur l'entité User
        return UserDetailsImpl.build(user);
    }
}

