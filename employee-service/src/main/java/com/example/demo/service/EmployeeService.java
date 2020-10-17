package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.dao.EmployeeDAO;
import com.example.demo.model.Employee;

@Repository
public class EmployeeService {
	
	EmployeeDAO employeeDao = new EmployeeDAO();
	
	public List<Employee> getAllEmployees() {		
		return employeeDao.getEmployees();
	}
	
	public Employee getEmployeeById(String empId) {		
		return employeeDao.getEmployeeById(empId);
	}
	
	public List<Employee> getEmployeeByName(String empName) {		
		return employeeDao.getEmployeeByName(empName);
	}


}
