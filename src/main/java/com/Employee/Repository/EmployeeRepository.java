package com.Employee.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Employee.Model.Employe;


@Repository
public interface EmployeeRepository extends JpaRepository<Employe, Long> {
	Optional<Employe> findByemail(String email);
}
