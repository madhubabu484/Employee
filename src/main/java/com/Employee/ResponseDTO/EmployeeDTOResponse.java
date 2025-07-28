package com.Employee.ResponseDTO;

import java.io.Serializable;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTOResponse implements Serializable {

	private Long Id;
	@NotBlank(message = "desiganation is Requried")
	private String desiganation;
	@Min(value = 18, message = "Age must be at least 18")	
	private int age;
	@NotBlank(message = "email is Requried")
	private String email;

}
