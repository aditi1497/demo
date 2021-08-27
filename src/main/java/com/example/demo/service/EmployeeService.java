package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.EmployeeRepository;
import com.example.demo.entity.Employee;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepository empRepository;

	public Employee createEmployee(Employee emp) {
		return empRepository.save(emp);
	}

	public List<Employee> createEmployees(List<Employee> users) {
		return empRepository.saveAll(users);
	}

	public Employee getEmployeeById(int id) {
		return empRepository.findById(id).orElse(null);
	}

	public List<Employee> getUsers() {
		return empRepository.findAll();
	}
	
	public Employee updateEmployee(Employee emp) {
		Employee oldEmp=null;
		Optional<Employee> optionalemp=empRepository.findById(emp.getId());
		if(optionalemp.isPresent()) {
			oldEmp=optionalemp.get();
			oldEmp.setName(emp.getName());
			oldEmp.setAddress(emp.getAddress());
			empRepository.save(oldEmp);
		}else {
			return new Employee();
		}
		return oldEmp;
	}
	
	public String deleteEmployeeById(int id) {
		empRepository.deleteById(id);
		return "Employee got deleted";
	}

}
