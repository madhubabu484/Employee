package com.Employee.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Employee.Model.Employe;
import com.Employee.RequestDTO.EmpRequestDTO;
import com.Employee.ResponseDTO.EmployeeDTOResponse;
import com.Employee.Service.EmployeeService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/vi/employee") // use of RequestMapping it is Map the Url with Specific Method inside the Class.
public class EmployeeController {

	@Autowired
	private EmployeeService employeeservice;

	@PostMapping("/employees")
	public ResponseEntity<EmployeeDTOResponse> createEmployee(
			@Valid @RequestBody EmpRequestDTO dto) {
		return ResponseEntity.ok(employeeservice.createEmployee(dto));
	}


	@GetMapping("/GetAllEmployees")
	public ResponseEntity<List<Employe>> getAllEmployees()
	{

		List<Employe> emps = employeeservice.GetAllEmployee();

		return new ResponseEntity<>(emps, HttpStatus.OK);




	}

	@GetMapping("/{EmployeeById}")
	public ResponseEntity<?> getById(@RequestParam("id")  Long Id)
	{
		EmployeeDTOResponse employeeFindById = employeeservice.EmployeeFindById(Id);

		return ResponseEntity.ok(employeeFindById);

	}
	
	@GetMapping("/DeleteById/{myid}")
	public ResponseEntity<?> DeleteById(@PathVariable("myid") Long Id)
	{
		EmployeeDTOResponse deletebyid = employeeservice.EmployeeDeleteById(Id);
		
		return ResponseEntity.ok(deletebyid);
	}
}