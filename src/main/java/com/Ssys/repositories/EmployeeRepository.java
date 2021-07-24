package com.Ssys.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Ssys.entities.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	
}
