package com.example.employeepayroll.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.employeepayroll.dto.EmployeePayrollDTO;
import com.example.employeepayroll.model.EmployeeData;

@Service
public class EmployeePayrollService implements IEmployeeService{


	private List<EmployeeData> employeePayrollList = new ArrayList<>();
	
	@Override
	public List<EmployeeData> getEmployeeData() {
		return employeePayrollList;
	}

	@Override
	public EmployeeData getEmployeeById(int empId) {
		EmployeeData employeeData=null;
		return employeeData;
	}

	@Override
	public EmployeeData createEmployee(EmployeePayrollDTO empDTO) {
		EmployeeData employeeData=null;
		return employeeData;
	}

	@Override
	public EmployeeData updateEmployee(int empId, EmployeePayrollDTO empDTO) {
		EmployeeData employeeData=null;
		return employeeData;
	}

	@Override
	public void deleteEmployee(int empId) {
		
	}
}
