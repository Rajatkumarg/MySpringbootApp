package com.rajat.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.*;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

	@Id
	private int empId;
	private String name;
	private double salary;
	
	
}
