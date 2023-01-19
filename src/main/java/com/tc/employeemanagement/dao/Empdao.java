package com.tc.employeemanagement.dao;

import java.util.List;

import com.tc.employeemanagement.entity.EmpEntity;

public interface Empdao {
	public boolean register(EmpEntity entity);

	public EmpEntity autihentication(EmpEntity entity);

	public boolean deleteEmployee(String empId);

	public boolean updateEmployee(EmpEntity entity,String email,String name,String pass);
	
	public List<EmpEntity> allEmployee();
	
	public List<EmpEntity> allEmployeeStarts(String alpha);

}
