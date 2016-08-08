package com.rain.taglib;

import java.util.Collection;
import java.util.HashSet;

public class Company {
	// 描述企业的名称
	private String name;
	// 存储Employee的Collection
	private Collection<Employee> employees = new HashSet<Employee>();
	private Employee employee;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Collection<Employee> getEmployees() {
		return employees;
	}
	public void addEmployee(Employee e){
		this.employees.add(e);
	}
}
