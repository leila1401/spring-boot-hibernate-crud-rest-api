package com.leila.springboothibernateMysqlcrudrestapi.service;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.leila.springboothibernateMysqlcrudrestapi.entity.Employee;

@Repository
public interface EmployeeService {
	Employee saveEmployee(Employee employee);
	List<Employee> getAllEmployees();
	Employee getEmployeeById(long id);
	Employee updateEmployee(Employee employee , long id);
	void deleteById(long id);

}
