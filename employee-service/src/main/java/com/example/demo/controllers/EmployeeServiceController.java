package com.example.demo.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;

@RestController
public class EmployeeServiceController {
	
	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	EmployeeService empservice;
	
	@RequestMapping(value = { "/test" }, method = RequestMethod.GET)
	public String test() {
		LOGGER.debug("test() request received");
		LOGGER.info("Info : Request received");
		LOGGER.error("Error : Request received");
		return "It's running";
	}



	@RequestMapping(value = { "/", "/employees" }, method = RequestMethod.GET)
	public List<Employee> getEmployeeList() {
		LOGGER.debug("Request /employees received");

		return empservice.getAllEmployees();
	}

	@RequestMapping(value = "/employees/{employeeId}", method = RequestMethod.GET)
	public Employee getEmployee(@PathVariable("employeeId")String empId) {
		return empservice.getEmployeeById(empId);
	}
	
	@RequestMapping(value = "/employee", method = RequestMethod.GET)
	public Employee firstPage() {

		Employee emp = new Employee();
		emp.setName("emp1");
		emp.setDesignation("manager");
		emp.setEmpId("1");
		emp.setSalary(3000);

		return emp;
	}

}
