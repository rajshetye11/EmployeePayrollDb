package com.example.employeepayroll.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.example.employeepayroll.service.IEmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	
	@Autowired
	public IEmployeeService employeeService;
	
	@RequestMapping({"","/","/get"})
	public ResponseEntity<ResponseDTO> getEmployeeData(){
		List<EmployeeData> employeeData = employeeService.getEmployeeData();
		ResponseDTO res = new ResponseDTO("Success of Get", employeeData);
		return new ResponseEntity<ResponseDTO>(res,HttpStatus.OK);
	}
	
	@GetMapping("/get/{empId}")
	public ResponseEntity<ResponseDTO> getEmployeePayrollData(@PathVariable("empId") int empId){
		EmployeeData employeeData=employeeService.getEmployeeById(empId);
		ResponseDTO res=new ResponseDTO("Get call Success",employeeData);
		return new ResponseEntity<ResponseDTO>(res,HttpStatus.OK);
	
	}
	
	@PostMapping("/create")
	public ResponseEntity<ResponseDTO> addEmployee(@RequestBody EmployeePayrollDTO empDTO)
	{
		EmployeeData employeeData = employeeService.createEmployee(empDTO);
		ResponseDTO res=new ResponseDTO("Created Employee PayrollSucessfully ",employeeData);
		return new ResponseEntity<ResponseDTO>(res,HttpStatus.OK);
	}
	
	@PutMapping("/update/{empId}") 
	public ResponseEntity<ResponseDTO> updateEmployee(@PathVariable("empId") int empId,@RequestBody EmployeePayrollDTO empDTO){
		EmployeeData employeeData = employeeService.updateEmployee(empId,empDTO);
		ResponseDTO res=new ResponseDTO("Updated Employee Payroll Sucessfully",employeeData);
		return new ResponseEntity<ResponseDTO>(res,HttpStatus.OK);

		
	}
	
	@DeleteMapping("/delete/{empId}")
	public ResponseEntity<ResponseDTO> deleteEmployeeData(@PathVariable("empId") int empId){
		employeeService.deleteEmployee(empId);
		ResponseDTO res=new ResponseDTO("Deleted Sucessfully","Deleted Id: "+empId);
		return new ResponseEntity<ResponseDTO>(res,HttpStatus.OK);
	}

	
}
