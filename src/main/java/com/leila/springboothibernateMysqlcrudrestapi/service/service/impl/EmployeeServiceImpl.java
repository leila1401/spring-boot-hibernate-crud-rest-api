package com.leila.springboothibernateMysqlcrudrestapi.service.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.leila.springboothibernateMysqlcrudrestapi.entity.Employee;
import com.leila.springboothibernateMysqlcrudrestapi.exception.RessourceNotFoundException;
import com.leila.springboothibernateMysqlcrudrestapi.repository.EmployeeRepository;
import com.leila.springboothibernateMysqlcrudrestapi.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	 EmployeeRepository employeeRepository;


	@Override
	public Employee saveEmployee(Employee employee) {
			return employeeRepository.save(employee);
	}



	@Override
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}



	@Override
	public Employee getEmployeeById(long id) {
//		Optional<Employee> employee = employeeRepository.findById(id);
//		if(employee.isPresent()) {
//			return employee.get();
//		}else {
//			throw new RessourceNotFoundException("Employee" , "id" , id);
//		}
		
		return employeeRepository.findById(id).orElseThrow(() -> new RessourceNotFoundException("Employee" , "id" , id));
	}



	@Override
	public Employee updateEmployee(Employee employee, long id) {
		//we need to check whether employee with given id exist in BD OR NOT
		Employee existingEmployee = employeeRepository.findById(id).orElseThrow(() ->
				new RessourceNotFoundException("Employee" , "id" , id));
		existingEmployee.setFirstName(employee.getFirstName());
		existingEmployee.setLastName(employee.getLastName());
		existingEmployee.setEmail(employee.getEmail());
		
		employeeRepository.save(existingEmployee);
		return existingEmployee;
	}



	@Override
	public void deleteById(long id) {
		//we need to check whether employee with given id exiest in BD OR NOT
		employeeRepository.findById(id).orElseThrow(() -> new RessourceNotFoundException("Employee" , "id" , id));
		
		employeeRepository.deleteById(id);

		
	}


	
	
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


