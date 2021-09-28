package com.example.employeepayroll.controller;

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

import com.example.employeepayroll.dto.EmployeePayrollDTO;
import com.example.employeepayroll.dto.ResponseDTO;
import com.example.employeepayroll.model.EmployeeData;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@RequestMapping({"","/","/get"})
	public ResponseEntity<ResponseDTO> getEmployeeData(){
		EmployeeData employeeData;
		employeeData = new EmployeeData(1, new EmployeePayrollDTO("Raj", 6969.00));
		ResponseDTO res = new ResponseDTO("Success of get", employeeData);
		return new ResponseEntity<ResponseDTO>(res,HttpStatus.OK);
	}
	
	@PostMapping("/create")
	public ResponseEntity<ResponseDTO> addEmployee(@RequestBody EmployeePayrollDTO empDTO)
	{
		EmployeeData employeeData=null;
		employeeData=new EmployeeData(3,empDTO);
		ResponseDTO res=new ResponseDTO("Created Employee Payroll Sucessfully ",employeeData);
		return new ResponseEntity<ResponseDTO>(res,HttpStatus.OK);
	}
	
	@PutMapping("/update/{empId}") 
	public ResponseEntity<ResponseDTO> updateEmployee(@PathVariable("empId") int empId,@RequestBody EmployeePayrollDTO empDTO){
		EmployeeData employeeData=null;
		employeeData=new EmployeeData(empId,empDTO);
		ResponseDTO res=new ResponseDTO("Updated Employee Payroll Sucessfully",employeeData);
		return new ResponseEntity<ResponseDTO>(res,HttpStatus.OK);

		
	}
	
	@DeleteMapping("/delete/{empId}")
	public ResponseEntity<ResponseDTO> deleteEmployeeData(@PathVariable("empId") int empId){
		ResponseDTO res=new ResponseDTO("Deleted Sucessfully","Deleted Id: "+empId);
		return new ResponseEntity<ResponseDTO>(res,HttpStatus.OK);
	}

	
}
