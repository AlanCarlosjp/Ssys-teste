package com.Ssys.DTO;

import java.io.Serializable;
import java.time.LocalDate;

import com.Ssys.entities.Employee;

public class EmployeeDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	private String name;
	private String email;
	private Double salary;
	private String departament;
	private LocalDate birthDate;
	

	public EmployeeDTO() {

	}

	public EmployeeDTO(Long id, String name, String email, Double salary, String departament, LocalDate birthDate) {

		this.id = id;
		this.name = name;
		this.email = email;
		this.departament = departament;
		this.salary = salary;
		this.birthDate = birthDate;
	}

	public EmployeeDTO(Employee prod) {

		this.id = prod.getId();
		this.name = prod.getName();
		this.email = prod.getDescription();
		this.salary = prod.getSalary();
		this.departament = prod.getDepartament();
		this.birthDate = prod.getBirthDate();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public String getDepartament() {
		return departament;
	}

	public void setDepartament(String departament) {
		this.departament = departament;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}




}
