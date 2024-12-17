
package com.gestion.vols.repositories;

import com.gestion.vols.entities.Plane;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaneRepository extends JpaRepository<Plane, Long> {

	List<Plane> findAll();
}
