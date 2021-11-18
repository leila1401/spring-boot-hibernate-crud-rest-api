package com.leila.springboothibernateMysqlcrudrestapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.leila.springboothibernateMysqlcrudrestapi.entity.Employee;
import com.leila.springboothibernateMysqlcrudrestapi.service.EmployeeService;


@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
	
	@Autowired
	 EmployeeService employeeService;
	

	@PostMapping
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee){
		return new ResponseEntity<Employee>(employeeService.saveEmployee(employee) , HttpStatus.OK);
	}
	
	@GetMapping
	public List<Employee> getAllEmployees(){
		return employeeService.getAllEmployees();
	}

	@GetMapping("{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") long id){
		return new ResponseEntity<Employee>(employeeService.getEmployeeById(id) , HttpStatus.OK);
	}
	
	
	@PutMapping("{id}")
		public ResponseEntity<Employee> updateEmployee(@PathVariable("id") long id ,
														@RequestBody Employee employee){
			return new ResponseEntity<Employee>(employeeService.updateEmployee(employee, id), HttpStatus.OK);
		}
	
	
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteById(@PathVariable("id") long id){
		employeeService.deleteById(id);
		return new ResponseEntity<String>("Employee deleted successfully!" , HttpStatus.OK);
	}
	
	
	
	
	
}
