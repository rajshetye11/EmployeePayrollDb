package com.example.employeepayroll.dto;

import lombok.Data;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
public class EmployeePayrollDTO {

	@Pattern(regexp="^[A-Z]{1}[a-zA-Z\\s]{2,}$",message="Employee name Invalid")
	public String name;
	
	public long salary;

	public EmployeePayrollDTO(String name, long salary) {
		super();
		this.name = name;
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "EmployeePayrollDTO [name=" + name + ", salary=" + salary + "]";
	}

}
