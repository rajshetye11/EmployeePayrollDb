package com.example.employeepayroll.model;

public class EmployeeData {
	
	private Integer empId;
	private String name;
	private Double salary;
	
	public EmployeeData(Integer emp_id,String name,Double salary) {
		this.empId = empId;
		this.name= name;
		this.salary = salary;
	}
	public Integer getEmpID() {
		return empId;
	}
	public void setEmpID(Integer empId) {
		this.empId = empId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "EmployeeData [empId=" + empId + ", name=" + name + ", salary=" + salary + "]";
	}
	
	
}
