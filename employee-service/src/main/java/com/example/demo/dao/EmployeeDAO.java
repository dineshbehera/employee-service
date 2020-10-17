package com.example.demo.dao;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.demo.model.Employee;

public class EmployeeDAO {
	
	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	
	List<Employee> empList;
	
	public List<Employee> getEmployees() {
		
		LOGGER.debug("getEmployees called...");
		
		empList = new ArrayList<Employee>();
		
		empList.add(new Employee("123", "Akash","Manager",50000.00));
		empList.add(new Employee("124", "Barsha","Team Lead",40000.00));
		empList.add(new Employee("125", "Badal","Devloper",20000.00));
		empList.add(new Employee("126", "Sital","Devloper",25000.00));

		LOGGER.debug("getEmployees called finished...");
		return empList;
	}
	
	public Employee getEmployeeById(String eId) {
		LOGGER.debug("getEmployeeById called for empId : "+eId);
		
		if(empList == null) {
			getEmployees();
		}
		for (Employee emp : empList) {
	        if (emp.getEmpId().equals(eId)) {
	        	LOGGER.debug("returned employee : "+emp);
	            return emp;
	        }
	    }
    	LOGGER.debug("No employee found for :  "+eId);

	    return new Employee();
	    //return new Employee("000", "Not found","Not found",0.00, "Not found");
	}
	
	public List<Employee> getEmployeeByName(String empName) {
		
		ArrayList<Employee> el = new ArrayList<Employee>();
		for (Employee emp : empList) {
	        if (emp.getName() == empName) {
	            el.add(emp);
	        }
	    }
	    return el;
	}
	
}
