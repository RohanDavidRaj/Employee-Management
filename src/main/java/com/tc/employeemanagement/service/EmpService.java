package com.tc.employeemanagement.service;

import com.tc.employeemanagement.entity.EmpEntity;


public interface EmpService {
	public boolean register(EmpEntity entity);
	public EmpEntity autihentication(EmpEntity entity);
}
