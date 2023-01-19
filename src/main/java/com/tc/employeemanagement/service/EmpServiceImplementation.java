package com.tc.employeemanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tc.employeemanagement.dao.EmpdaoImplementation;
import com.tc.employeemanagement.entity.EmpEntity;

@Service
public  class EmpServiceImplementation implements EmpService {

	@Autowired
	private EmpdaoImplementation dao;

	@Override
	public boolean register(EmpEntity entity) {
		if (entity.getEmpId().startsWith("TY")) {
			return dao.register(entity);
		}
		return false;
	}

	@Override
	public EmpEntity autihentication(EmpEntity entity) {
		System.out.println("Serviceee layer");
		if (entity.getEmpId().startsWith("TY")) {
			System.out.println("data from dao---> "+ dao.autihentication(entity));
			return dao.autihentication(entity);
		}
		System.out.println("Service return null");
		return null;
	}

	public boolean deleteEmployee(String empId) {
		return dao.deleteEmployee(empId);

	}

	@Override
	public boolean updateEmployee(EmpEntity entity, String email,String name,String pass) {

		return dao.updateEmployee(entity, email,name,pass);
	}

	@Override
	public List<EmpEntity> allEmployeeService() {
		
		return dao.allEmployee();
	}
	
	public List<EmpEntity> allEmployeeStarts(String alpha){
		return dao.allEmployeeStarts(alpha);
	}





}
