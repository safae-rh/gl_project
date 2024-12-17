
package com.gestion.vols.services;

import com.gestion.vols.entities.Staff;
import com.gestion.vols.repositories.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StaffService {

    @Autowired
    private StaffRepository staffRepository;

    // Fetch all staff
    public List<Staff> getAllStaff() {
        return staffRepository.findAll();
    }

    // Fetch a staff by ID
    public Optional<Staff> getStaffById(Long id) {
        return staffRepository.findById(id);
    }

    // Save a new staff member
    public Staff saveStaff(Staff staff) {
        return staffRepository.save(staff);
    }

    // Delete a staff member by ID
    public void deleteStaff(Long id) {
        staffRepository.deleteById(id);
    }

	public Staff updateStaff(Long id, Staff staffDetails) {
		// TODO Auto-generated method stub
		return null;
	}
}
