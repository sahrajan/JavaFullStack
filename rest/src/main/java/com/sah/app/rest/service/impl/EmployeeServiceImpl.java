package com.sah.app.rest.service.impl;


import java.util.List;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sah.app.rest.service.*;

import net.bytebuddy.dynamic.DynamicType.Builder.FieldDefinition.Optional;

import com.sah.app.rest.repo.*;
import com.sah.app.rest.model.*;
import com.sah.app.rest.exception.*;



@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService{

	private employeeRepo employeeRepo;
	
	public EmployeeServiceImpl(employeeRepo employeeRepo) {
		super();
		this.employeeRepo = employeeRepo;
	}

	@Override
	public employee saveEmployee(employee employee) {
		return employeeRepo.save(employee);
	}

	@Override
	public List<employee> getAllEmployees() {
		return employeeRepo.findAll();
	}

	@Override
	public employee getEmployeeById(long id) {
		
		return employeeRepo.findById(id).orElseThrow(() -> 
						new resourceNotFoundException("Employee", "Id", id, 0));
		
	}

	@Override
	public employee updateEmployee(employee employee, long id) {
		
		// we need to check whether employee with given id is exist in DB or not
		employee existingEmployee = employeeRepo.findById(id).orElseThrow(
				() -> new resourceNotFoundException("Employee", "Id", id, 0)); 
		
		existingEmployee.setFirstName(employee.getFirstName());
		existingEmployee.setLastName(employee.getLastName());
		existingEmployee.setEmail(employee.getEmail());
		existingEmployee.setAge(employee.getAge());
		// save existing employee to DB
		employeeRepo.save(existingEmployee);
		return existingEmployee;
	}

	@Override
	public void deleteEmployee(long id) {
		
		// check whether a employee exist in a DB or not
		employeeRepo.findById(id).orElseThrow(() -> 
								new resourceNotFoundException("Employee", "Id", id, 0));
		employeeRepo.deleteById(id);
	}
	
}