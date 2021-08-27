package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Employee;
import com.example.demo.service.EmployeeService;

@RestController
public class EmployeeController {
	@Autowired
	private EmployeeService empService;

	@PostMapping("/addEmployee")
	public Employee addEmployee(@RequestBody Employee emp) {
		return empService.createEmployee(emp);
	}

	@PostMapping("/addEmployees")
	public List<Employee> addEmployee(@RequestBody List<Employee> emp) {
		return empService.createEmployees(emp);
	}

	@GetMapping("/employee/{id}")
	public Employee getEmployeeById(@PathVariable int id) {
		return empService.getEmployeeById(id);
	}

	@GetMapping("/employees")
	public List<Employee> getAllUsers() {
		return empService.getUsers();
	}
	
	@PutMapping("/updateuser")
	public Employee updateUser(@RequestBody Employee emp) {
		return empService.updateEmployee(emp);
	}

	@DeleteMapping("/user/{id}")
	public String deleteUser(@PathVariable int id) {
		return empService.deleteEmployeeById(id);
	}
}
