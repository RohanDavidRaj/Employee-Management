package com.tc.employeemanagement.service;

import java.util.List;

import com.tc.employeemanagement.entity.EmpEntity;

public interface EmpService {
	public boolean register(EmpEntity entity);

	public EmpEntity autihentication(EmpEntity entity);

	public boolean deleteEmployee(String id);

	public boolean updateEmployee(EmpEntity entity, String email, String name, String pass);

	public List<EmpEntity> allEmployeeService();
	
	public List<EmpEntity> allEmployeeStarts(String alpha);

	
	

}
