package com.tc.employeemanagement.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.springframework.stereotype.Repository;

import com.tc.employeemanagement.entity.EmpEntity;

@Repository
public class EmpdaoImplementation implements Empdao {

	@Override
	public boolean register(EmpEntity entity) {

		boolean register = false;
		try {

			EntityManagerFactory factory = Persistence.createEntityManagerFactory("employee");
			EntityManager manager = factory.createEntityManager();
			EntityTransaction transaction = manager.getTransaction();

			transaction.begin();

			manager.persist(entity);

			transaction.commit();
			register = true;
		} catch (Exception e) {
			e.printStackTrace();

		}
		return register;
	}

	@Override
	public EmpEntity autihentication(EmpEntity entity) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("employee");
		EntityManager manager = factory.createEntityManager();
		EmpEntity find = manager.find(EmpEntity.class, entity.getEmpId());
		if (find != null) {
			if (find.getEmpPass().equals(entity.getEmpPass())) {
				return find;
			}
		}
		return null;
	}

}
