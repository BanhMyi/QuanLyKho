package com.quanlykho.service.base;

import java.util.List;

import com.quanlykho.model.Employee;

public interface EmployeeService {

		public List<Employee> getAllEmployees();
		public Employee getEmployeeById(Integer id);
		public void addEmployee(Employee employee);
		public void deactiveEmployee(Integer Id);
		Employee findByName(String name);
		public List<Employee> searchEmployees(String term);
}
