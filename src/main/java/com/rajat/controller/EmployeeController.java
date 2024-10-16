package com.rajat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.PutExchange;

import java.util.List;

import com.rajat.entity.Employee;
import com.rajat.repo.EmployeeRepo;
import com.rajat.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	
	@Autowired
	EmployeeService employeeService;
	
	@GetMapping("/getEmployee")
	public List<Employee> getEmployee() {
		return employeeService.getEmployee();
	}
	
	@PostMapping("/saveEmployee")
	public ResponseEntity<String> saveEmployee(@RequestBody Employee e){
		String resp = employeeService.saveEmployee(e);
		return new ResponseEntity<String>(resp, HttpStatus.OK);
	}
	
	@PutMapping("/updateEmployee/{id}")
	public String updateEmployee(@RequestParam String name,@RequestParam double salary, @PathVariable int id) {
		String resp = null;
		resp = employeeService.updateEmployee(id, name, salary);
		return resp;
	}
	
	@DeleteMapping("/deleteEmployee/{empId}")
	public String deleteEmployee(@PathVariable int empId) {
		return employeeService.deleteEmployee(empId);
	}
	
}
