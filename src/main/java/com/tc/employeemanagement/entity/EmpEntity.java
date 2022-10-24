package com.tc.employeemanagement.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "employee_info")
public class EmpEntity implements Serializable {
  
	@Id
	@Column(name = "emp_Id")
	private String empId;
	@Column(name = "emp_Name")
	private String empName;
	@Column(name = "emp_Email")
	private String empEmail;
	@Column(name = "password")
	private String empPass;
	
	
}
