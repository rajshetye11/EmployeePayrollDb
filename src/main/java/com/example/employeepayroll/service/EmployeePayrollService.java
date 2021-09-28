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
		return employeePayrollList.get(empId-1);
	}

	@Override
	public EmployeeData createEmployee(EmployeePayrollDTO empDTO) {
		EmployeeData employeeData= new EmployeeData(1,empDTO);
		employeePayrollList.add(employeeData);
		return employeeData;
	}

	@Override
	public EmployeeData updateEmployee(int empId, EmployeePayrollDTO empDTO) {
		EmployeeData employeeData= getEmployeeById(empId);
		employeeData.setName(empDTO.getName());
		employeeData.setSalary(empDTO.getSalary());
		employeePayrollList.set(empId, employeeData);
		return employeeData;
	}

	@Override
	public void deleteEmployee(int empId) {
		employeePayrollList.remove(empId-1);
	}
}
