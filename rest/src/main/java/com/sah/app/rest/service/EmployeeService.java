package com.sah.app.rest.service;



import java.util.List;
import com.sah.app.rest.model.employee;


public interface EmployeeService {
	employee saveEmployee(employee employee);
	List<employee> getAllEmployees();
	employee getEmployeeById(long id);
	employee updateEmployee(employee employee, long id);
	void deleteEmployee(long id);
}