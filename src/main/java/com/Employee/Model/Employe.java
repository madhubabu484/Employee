package com.Employee.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name ="EMP_Table")
public class Employe {

	@jakarta.persistence.Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "EMP_Id")
	private Long id;
	@Column(name = "EMP_Name")
	private String name;
	@Column(name = "email")
	private String email;
    @Column(name = "EMP_Age")
	private int age;
	@Column(name = "EMP_Desiganation")
	private String desiganation;
	@Column(name = "EMP_Salary")
	private Double salary;


}
