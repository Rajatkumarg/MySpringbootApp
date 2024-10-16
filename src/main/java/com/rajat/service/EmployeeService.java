package com.rajat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.rajat.entity.Employee;
import com.rajat.repo.EmployeeRepo;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepo employeeRepo;
	
	public List<Employee> getEmployee() {
		return employeeRepo.findAllSortedByEmployeeId();
	}
	
	public String saveEmployee(@RequestBody Employee e){
		employeeRepo.save(e);
		return "Employee added";
	}

	public String updateEmployee(int empId, String name, double salary) {
		Employee emp = employeeRepo.findById(empId).orElse(null);
		String resp = null;
		if(emp!=null) {
			emp.setName(name);
			emp.setSalary(salary);
			employeeRepo.save(emp);
			resp = "Employee "+empId+" updated successfully";
		}
		else {
			resp = "Employee "+empId+" not found!";
		}
		return resp;
	}

	public String deleteEmployee(int empId) {
		Employee emp = employeeRepo.findById(empId).orElse(null);
		if(emp==null) {
			return "Employee not found";
		} else {
			employeeRepo.deleteById(empId);
			return "Employee deleted";
		}
	}
}
