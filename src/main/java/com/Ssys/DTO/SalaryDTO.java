package com.Ssys.DTO;

import java.io.Serializable;

public class SalaryDTO implements Serializable,Comparable<EmployeeDTO>{

	private static final long serialVersionUID = 1L;

	private EmployeeDTO Lowest;
	private EmployeeDTO Highest;
	private Double average;
	
	
	public SalaryDTO() {

	}

	public SalaryDTO(EmployeeDTO Lowest, EmployeeDTO Highest, Double average) {
		super();
		this.Lowest = Lowest;
		this.Highest = Highest;
		this.average = average;
	}

	
	public EmployeeDTO getLowest() {
		return Lowest;
	}

	public void setLowest(EmployeeDTO lowest) {
		Lowest = lowest;
	}

	public EmployeeDTO getHighest() {
		return Highest;
	}

	public void setHighest(EmployeeDTO highest) {
		Highest = highest;
	}

	public Double getAverage() {
		return average;
	}

	public void setAverage(Double average) {
		this.average = average;
	}

	@Override
	public int compareTo(EmployeeDTO o) {
		
		return o.getSalary().compareTo(new EmployeeDTO().getSalary());
	}

	
}
