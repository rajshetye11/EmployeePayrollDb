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
	 IEmployeeService service;
	 
	 
     @RequestMapping(value={"/get"})
     public ResponseEntity<ResponseDTO> getEmployeePayrollData()
     {
    	 List<EmployeeData> empDataList=null;
    	 empDataList=service.getEmployeeData();
    	 ResponseDTO respDTO=new ResponseDTO("Get call successful",empDataList);
    	 return new ResponseEntity<ResponseDTO>(respDTO,HttpStatus.OK);
     }
     
     @GetMapping("/get/{empId}")
     public ResponseEntity<ResponseDTO> getEmployeePayrollData(@PathVariable("empId") int empId)
     {
    	 EmployeeData emp=null;
    	 emp=service.getEmployeeData(empId);
    	 ResponseDTO respDTO=new ResponseDTO("Get call  successful",emp);
    	 return new ResponseEntity<ResponseDTO>(respDTO,HttpStatus.OK);
     }
     
     @PostMapping("/create")
     public ResponseEntity<ResponseDTO> addEmployeePayrollData(@Valid @RequestBody EmployeePayrollDTO empPayrollDto)
     {
    	 EmployeeData emp=null;
    	 emp=service.addEmployeeData(empPayrollDto);
    	 ResponseDTO respDTO=new ResponseDTO("created employee payroll data successful",emp);
    	 return new ResponseEntity<ResponseDTO>(respDTO,HttpStatus.OK);
     }
     
     @PutMapping("/update")
     public ResponseEntity<ResponseDTO> updateEmployeePayrollData(@Valid @RequestBody EmployeePayrollDTO empPayrollDto)
     {
    	 EmployeeData emp=null;
    	 emp=service.updateEmployee(1,empPayrollDto);
    	 ResponseDTO respDTO=new ResponseDTO("Updated employee payroll data successfully",emp);
    	 return new ResponseEntity<ResponseDTO>(respDTO,HttpStatus.OK);
     }
     
     @DeleteMapping("/get/{empId}")
     public ResponseEntity<ResponseDTO> deleteEmployeePayrollData(@PathVariable("empId") int empId)
     {
    	 service.deleteEmployee(empId);
    	 ResponseDTO respDTO=new ResponseDTO("Deleted successfully","Deleted id = "+empId);
    	 return new ResponseEntity<ResponseDTO>(respDTO,HttpStatus.OK);
     }

	
}
