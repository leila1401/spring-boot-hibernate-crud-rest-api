package com.leila.springboothibernateMysqlcrudrestapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.leila.springboothibernateMysqlcrudrestapi.entity.Employee;


public interface EmployeeRepository extends JpaRepository<Employee, Long> {


}
