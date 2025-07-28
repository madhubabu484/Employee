package com.Employee.ResponseDTO;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllUsersDetailsResponseDTO implements Serializable {

	private Long Id;

	private String name;

	private int Age;

	private String email;

	private String desiganation;

}
