package com.tc.employeemanagement.dao;

import com.tc.employeemanagement.entity.EmpEntity;


public interface Empdao {
	public boolean register(EmpEntity entity);
	public EmpEntity autihentication(EmpEntity entity);
}
