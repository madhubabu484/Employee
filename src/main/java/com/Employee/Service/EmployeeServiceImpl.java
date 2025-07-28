package com.Employee.Service;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Employee.CustomExceptions.EmailAlredyexistexception;
import com.Employee.Model.Employe;
import com.Employee.Repository.EmployeeRepository;
import com.Employee.RequestDTO.EmpRequestDTO;
import com.Employee.ResponseDTO.EmployeeDTOResponse;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository emprepository;

	@Override
	public EmployeeDTOResponse createEmployee(EmpRequestDTO dto)

	{
		
		
		  Optional<Employe> existemployee = emprepository.findByemail(dto.getEmail());
		  
		  if(existemployee.isPresent())
		  {
	            throw new EmailAlredyexistexception("Email is already used by another user: " + dto.getEmail());

		  }
		  
		    Employe emp = new Employe();
		    
		     emp.setName(dto.getName());
		     emp.setAge(dto.getAge());
		     emp.setEmail(dto.getEmail());
		     emp.setSalary(dto.getSalary());
		     emp.setDesiganation(dto.getDesiganation());
		     
		    
		       
		

		Employe savedemploye = emprepository.save(emp);

		//Step 3: Convert Entity to Response
		EmployeeDTOResponse response = new EmployeeDTOResponse();

		response.setAge(emp.getAge());

		response.setId(emp.getId());

		response.setDesiganation(emp.getDesiganation());

		response.setEmail(emp.getEmail());

		return response;
	}


	@Override
	public List<EmployeeDTOResponse> GetAllEmployee() {
		return null;
	}

	@Override
	public void EmployeeFindById(Long Id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void EmployeeDeleteById(Long Id) {
		// TODO Auto-generated method stub

	}

	@Override
	public Void EmployeeUpdateById(Long Id) {
		// TODO Auto-generated method stub
		return null;
	}


}


	




