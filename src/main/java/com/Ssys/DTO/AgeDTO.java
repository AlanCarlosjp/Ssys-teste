package com.Ssys.DTO;

import java.io.Serializable;

public class AgeDTO implements Serializable,Comparable<EmployeeDTO>{

	private static final long serialVersionUID = 1L;

	private EmployeeDTO younger;
	private EmployeeDTO older;
	private Integer average;
	
	
	public AgeDTO() {

	}

	public AgeDTO(EmployeeDTO younger, EmployeeDTO older, Integer average) {
		super();
		this.younger = younger;
		this.older = older;
		this.average = average;
	}

	public EmployeeDTO getYounger() {
		return younger;
	}

	public void setYounger(EmployeeDTO younger) {
		this.younger = younger;
	}

	public EmployeeDTO getOlder() {
		return older;
	}

	public void setOlder(EmployeeDTO employeeDTO) {
		this.older = employeeDTO;
	}

	public Integer getAverage() {
		return average;
	}

	public void setAverage(Integer average) {
		this.average = average;
	}

	@Override
	public int compareTo(EmployeeDTO o) {
		
		return o.getBirthDate().compareTo(new EmployeeDTO().getBirthDate());
	}

	
}
