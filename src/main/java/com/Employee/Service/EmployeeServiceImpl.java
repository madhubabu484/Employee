package com.Employee.Service;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Employee.CustomExceptions.DeleteNotFoundWithId;
import com.Employee.CustomExceptions.EmailAlredyexistexception;
import com.Employee.CustomExceptions.EmployeNotFoundWithId;
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

		// Step 1 : we have to do the first  Convert   to the DTO to Entity Class.
		Employe emp = new Employe();

		emp.setName(dto.getName());
		emp.setAge(dto.getAge());
		emp.setEmail(dto.getEmail());
		emp.setSalary(dto.getSalary());
		emp.setDesiganation(dto.getDesiganation());

		// Step 2 : After the ConverT Dto to Entity  we have to save the Inside the DataBase.
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
	public List<Employe> GetAllEmployee() {

		List<Employe> emps = emprepository.findAll();

		return emps ;
	}
	@Override
	public EmployeeDTOResponse EmployeeFindById(Long Id) {
		Optional<Employe> byId = emprepository.findById(Id);
		if(byId.isPresent()) {
			Employe employe = byId.get();
			EmployeeDTOResponse dto=new EmployeeDTOResponse();
			dto.setId(employe.getId());
			dto.setEmail(employe.getEmail());
			dto.setAge(employe.getAge());
			dto.setDesiganation(employe.getDesiganation());
			return dto;
		}
		 throw new EmployeNotFoundWithId("Employee not found with Id : "+Id);
	}
	@Override
	public EmployeeDTOResponse EmployeeDeleteById(Long Id) {
		
		    Employe employe = emprepository.findById(Id)
		        .orElseThrow(() -> new EmployeNotFoundWithId("Employee not found with Id: " + Id));

		    // ✅ Create DTO before deleting the entity
		    EmployeeDTOResponse dto = new EmployeeDTOResponse();
		    dto.setId(employe.getId());
		    dto.setEmail(employe.getEmail());
		    dto.setAge(employe.getAge());
		    dto.setDesiganation(employe.getDesiganation());

		    // ✅ Delete employee from DB
		    emprepository.delete(employe);

		    // ✅ Return DTO as response
		    return dto;
		}

	
		
		

	@Override
	public Void EmployeeUpdateById(Long Id) {
		// TODO Auto-generated method stub
		return null;
	}


}







