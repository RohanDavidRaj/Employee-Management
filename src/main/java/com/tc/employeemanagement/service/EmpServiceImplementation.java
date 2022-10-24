package com.tc.employeemanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tc.employeemanagement.dao.EmpdaoImplementation;
import com.tc.employeemanagement.entity.EmpEntity;

@Service
public class EmpServiceImplementation implements EmpService {

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
		if (entity.getEmpId().startsWith("TY")) {
			return dao.autihentication(entity);
		}
		return null;
	}

}
