package com.Ssys.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Ssys.DTO.AgeDTO;
import com.Ssys.DTO.EmployeeDTO;
import com.Ssys.DTO.SalaryDTO;
import com.Ssys.entities.Employee;
import com.Ssys.repositories.EmployeeRepository;
import com.Ssys.services.exception.DataBaseException;
import com.Ssys.services.exception.ResourceNotFoundException;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository repo;

	@Transactional(readOnly = true)
	public Page<EmployeeDTO> findAllPaged(PageRequest pageRequest) {
		Page<Employee> list = repo.findAll(pageRequest);

		return list.map(x -> new EmployeeDTO(x));
	}

	@Transactional(readOnly = true)
	public EmployeeDTO findById(Long id) {
		Optional<Employee> obj = repo.findById(id);
		Employee entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not exist"));
		return new EmployeeDTO(entity);

	}

	@Transactional
	public EmployeeDTO insert(EmployeeDTO dto) {
		Employee entity = new Employee();

		copyDtoForEntity(entity, dto);

		repo.save(entity);

		return new EmployeeDTO(entity);
	}

	@Transactional
	public EmployeeDTO update(Long id, EmployeeDTO dto) {

		if (repo.existsById(id)) {
			Employee entity = new Employee();

			entity.setId(id);

			copyDtoForEntity(entity, dto);

			repo.save(entity);

			return new EmployeeDTO(entity);
		}
		throw new EntityNotFoundException("ID not exist");
	}

	public void delete(Long id) {
		try {
			repo.deleteById(id);
		} catch (EmptyResultDataAccessException e) {

			throw new EntityNotFoundException("Id not exist");
		} catch (DataIntegrityViolationException e) {
			throw new DataBaseException("Integrity violation");
		}
	}

	private void copyDtoForEntity(Employee entity, EmployeeDTO dto) {
		entity.setName(dto.getName());
		entity.setEmail(dto.getEmail());
		entity.setDepartament(dto.getDepartament());
		entity.setSalary(dto.getSalary());
		entity.setBirthDate(dto.getBirthDate());
	}

	public AgeDTO findForAge() {
		List<Employee> emps = new ArrayList<>();

		emps = repo.findAll();

		List<EmployeeDTO> dto = new ArrayList<>();

		for (Employee x : emps) {

			dto.add(new EmployeeDTO(x));
		}
		dto.sort((x, y) -> x.getBirthDate().compareTo(y.getBirthDate()));

		AgeDTO age = new AgeDTO();

		age.setOlder(dto.get(0));

		age.setYounger(dto.get(dto.size() - 1));

		Integer y =  2021 - age.getYounger().getBirthDate().getYear() ;
		Integer o = 2021 - age.getOlder().getBirthDate().getYear();
		
		age.setAverage((o + y) / 2);
		
		return age;
	}

	public SalaryDTO findSalary() {
		List<Employee> emps = new ArrayList<>();
		
		emps = repo.findAll();
		
		List<EmployeeDTO> dto = new ArrayList<>();

		for (Employee x : emps) {

			dto.add(new EmployeeDTO(x));
		}
		
		dto.sort((x,y) -> x.getSalary().compareTo(y.getSalary()));
		
		SalaryDTO sal = new SalaryDTO();
		
		sal.setLowest(dto.get(0));
		sal.setHighest(dto.get(dto.size() - 1));
		
		Double x = sal.getHighest().getSalary();
		Double y = sal.getLowest().getSalary();
		
		sal.setAverage((y + x) / 2.0);
		
		return sal;
	}
}
