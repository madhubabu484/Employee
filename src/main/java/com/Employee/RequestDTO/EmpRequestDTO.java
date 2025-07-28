package com.Employee.RequestDTO;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmpRequestDTO {

	private Long id;
	@NotBlank(message = "Name is Requried")
    private String name;
	@Min(value = 18, message = "Age must be at least 18")
    private int age;
	@NotBlank(message ="desiganation is requried")
    private String desiganation;
	@NotNull(message = "salary is Requried")
    private Double salary;
	@NotBlank(message = "email is Requried")
    private String email;

}
