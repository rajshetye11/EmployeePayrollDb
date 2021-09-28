package com.example.employeepayroll.service;

import java.util.List;

import com.example.employeepayroll.dto.EmployeePayrollDTO;
import com.example.employeepayroll.model.EmployeeData;

public interface IEmployeeService {

	List<EmployeeData> getEmployeeData();

	EmployeeData getEmployeeById(int empId);

	EmployeeData createEmployee(EmployeePayrollDTO empDTO);

	EmployeeData updateEmployee(int empId, EmployeePayrollDTO empDTO);

	void deleteEmployee(int empId);
}
