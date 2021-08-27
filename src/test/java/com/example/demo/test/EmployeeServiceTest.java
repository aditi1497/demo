package com.example.demo.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import java.util.List;
import java.util.Optional;

import com.example.demo.dao.EmployeeRepository;
import com.example.demo.entity.Employee;
import com.example.demo.service.EmployeeService;

public class EmployeeServiceTest {
	//private MockMvc mockMvc;
	@InjectMocks
	private EmployeeService empServiceMock = new EmployeeService();
	@Mock
	private EmployeeRepository empRepo;

	@BeforeEach
	public void setup() {

		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void empSaveTest() throws Exception {
		Employee emp = new Employee();
		emp.setId(1);
		emp.setName("Aditi");
		emp.setGender("female");
		emp.setYoe("2");
		emp.setAddress("Lucknow");

		when(empRepo.save(emp)).thenReturn(emp);

		Employee empResponse = empServiceMock.createEmployee(emp);
		assertEquals(emp, empResponse);
	}
	@Test
	public void empsSaveTest() throws Exception {
		Employee emp = new Employee();
		emp.setId(1);
		emp.setName("Aditi");
		emp.setGender("female");
		emp.setYoe("2");
		emp.setAddress("Lucknow");
		Employee emp1 = new Employee();
		emp1.setId(2);
		emp1.setName("Navjyot");
		emp1.setAddress("Lucknow");
		List<Employee> list=new ArrayList<>();
		list.add(emp);
		list.add(emp1);

		when(empRepo.saveAll(list)).thenReturn(list);

		List<Employee> empResponse = empServiceMock.createEmployees(list);
		assertEquals(list, empResponse);
	}
	@Test
	public void getEmployeeByIdTest() throws Exception {
		
		Employee emp = new Employee();
		emp.setId(1);
		emp.setName("Aditi");
		emp.setGender("female");
		emp.setYoe("2");
		emp.setAddress("Lucknow");
		

		when(empRepo.findById(1)).thenReturn(Optional.of(emp));

		Employee empResponse = empServiceMock.getEmployeeById(1);
		assertEquals(emp, empResponse);
	}
	@Test
	public void getUsersTest() throws Exception {
		
		Employee emp = new Employee();
		emp.setId(1);
		emp.setName("Aditi");
		emp.setGender("female");
		emp.setYoe("2");
		emp.setAddress("Lucknow");
		Employee emp1 = new Employee();
		emp1.setId(2);
		emp1.setName("Navjyot");
		emp1.setAddress("Lucknow");
		List<Employee> list=new ArrayList<>();
		list.add(emp);
		list.add(emp1);
		

		when(empRepo.findAll()).thenReturn(list);

		List<Employee> empResponse = empServiceMock.getUsers();
		assertEquals(list, empResponse);
	}
	@Test
	public void deleteEmployeeByIdTest() throws Exception {


		String empResponse = empServiceMock.deleteEmployeeById(1);
		assertEquals("Employee got deleted", empResponse);
	}
	@Test
	public void updateEmployeeTest() throws Exception {
		Employee emp = new Employee();
		emp.setId(1);
		emp.setName("Aditi");
		emp.setGender("female");
		emp.setYoe("2");
		emp.setAddress("kanpur");
		
		when(empRepo.findById(1)).thenReturn(Optional.of(emp));

		Employee empResponse = empServiceMock.updateEmployee(emp);
		assertEquals(emp, empResponse);
	}

}
