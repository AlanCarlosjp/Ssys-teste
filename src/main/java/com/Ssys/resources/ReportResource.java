package com.Ssys.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Ssys.DTO.AgeDTO;
import com.Ssys.DTO.SalaryDTO;
import com.Ssys.services.EmployeeService;

@RestController
@RequestMapping(value = "/reports/employees")
public class ReportResource {

	@Autowired
	private EmployeeService service;

	@GetMapping(value = "/age")
	public ResponseEntity<AgeDTO> findForAge(){
		
		AgeDTO age = service.findForAge();
		
		return ResponseEntity.ok().body(age);
		
		}
	
	@GetMapping(value = "/salary")
	public ResponseEntity<SalaryDTO> findForSalary(){
		
		SalaryDTO sal = service.findSalary();
		
		return ResponseEntity.ok().body(sal);
	}

}