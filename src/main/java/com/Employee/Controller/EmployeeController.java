package com.Employee.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	
	@PostMapping("/create")
    public ResponseEntity<EmployeeDTOResponse> createEmployee1(@Valid @RequestBody EmpRequestDTO requestDto) {
        EmployeeDTOResponse response = employeeservice.createEmployee(requestDto);
        return ResponseEntity.ok(response);
	}



	}


