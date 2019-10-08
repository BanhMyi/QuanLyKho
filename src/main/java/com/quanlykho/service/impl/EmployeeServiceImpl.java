package com.quanlykho.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.quanlykho.model.Employee;
import com.quanlykho.repository.base.EmployeeRepository;
import com.quanlykho.service.base.EmployeeService;
@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> allEmployees = new ArrayList<>();
		employeeRepository.findAll().forEach(allEmployees :: add);
		return allEmployees;
	}

	@Override
	public Employee getEmployeeById(Integer id) {
		return employeeRepository.findById(id).get();
	}

	@Override
	public void addEmployee(Employee employee) {
		employee.setRole("ROLE_USER");
		employee.setStatus("active");
		employee.setPassword(passwordEncoder.encode(employee.getRawPassword()));
		employeeRepository.save(employee);

	}

	@Override
	public void deactiveEmployee(Integer id) {
		employeeRepository.deactiveEmployee(id);

	}

	@Override
	public Employee findByName(String name) {
		return employeeRepository.findByUserName(name);
	}

	@Override
	public List<Employee> searchEmployees(String term) {
		return employeeRepository.searchByName(term);
	}

}
