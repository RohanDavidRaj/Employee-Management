package com.tc.employeemanagement.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.From;
import javax.print.attribute.standard.PrinterMessageFromOperator;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.mysql.cj.Session;
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

		EmpEntity empEntity = manager.find(EmpEntity.class, entity.getEmpId());
		System.out.println("full data table--- " + empEntity);
		if (empEntity.getEmpId() != null) {
			if (empEntity.getEmpPass().equals(entity.getEmpPass())) {
				return empEntity;
			}
		}
		return null;
	}

	@Override
	public boolean deleteEmployee(String empId) {
		boolean isDeleted = false;
		try {
			EntityManagerFactory factory = Persistence.createEntityManagerFactory("employee");
			EntityManager manager = factory.createEntityManager();
			EntityTransaction transaction = manager.getTransaction();
			transaction.begin();

			EmpEntity find = manager.find(EmpEntity.class, empId);
			manager.remove(find);

			transaction.commit();
			isDeleted = true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return isDeleted;
	}

	@Override
	public boolean updateEmployee(EmpEntity entity, String email, String name, String pass) {

		boolean isUpdated = false;
		try {
			EntityManagerFactory factory = Persistence.createEntityManagerFactory("employee");
			EntityManager manager = factory.createEntityManager();
			EntityTransaction transaction = manager.getTransaction();

			EmpEntity find = manager.find(EmpEntity.class, entity.getEmpId());
			transaction.begin();
			find.setEmpName(" " + name + " ");
			find.setEmpEmail(" " + email + " ");
			find.setEmpPass(" " + pass + " ");

			transaction.commit();

			isUpdated = true;

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return isUpdated;
	}

	@Override
	public List<EmpEntity> allEmployee() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("employee");
		EntityManager manager = factory.createEntityManager();
	    
		String query="from EmpEntity";
	    Query createQuery = manager.createQuery(query);
	    List<EmpEntity> resultList = createQuery.getResultList();
		return resultList;
	}

	@Override
	public List<EmpEntity> allEmployeeStarts(String alpha) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("employee");
		EntityManager manager = factory.createEntityManager();
		
	    
		String query="from EmpEntity where empName Like"+"'"+alpha+"%'";
//		String query="FROM EmpEntity where empName LIKE '%r' ";
		
		
	    Query createQuery = manager.createQuery(query);
	    List<EmpEntity> resultList = createQuery.getResultList();
		return resultList;
	}
}
