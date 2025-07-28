package com.Employee.Service;

import java.util.List;

import com.Employee.Model.Employe;
import com.Employee.RequestDTO.EmpRequestDTO;
import com.Employee.ResponseDTO.EmployeeDTOResponse;

public interface EmployeeService {
	
	
	EmployeeDTOResponse createEmployee(EmpRequestDTO emprequestdto);
	
	List<EmployeeDTOResponse> GetAllEmployee();
	
	void EmployeeFindById(Long Id);
	
	void EmployeeDeleteById(Long Id);
	
	Void EmployeeUpdateById(Long Id);
	
	
	

}
