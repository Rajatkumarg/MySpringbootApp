package com.rajat.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.rajat.entity.Employee;

public interface EmployeeRepo extends MongoRepository<Employee, Integer>{

	@Query(value = "{}" , sort = "{'empId' : 1}")
	List<Employee> findAllSortedByEmployeeId();
}
