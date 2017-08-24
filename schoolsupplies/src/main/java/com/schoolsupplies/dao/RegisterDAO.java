package com.schoolsupplies.dao;

/**
import java.util.List;
**/

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
import com.mobile.model.Category;
import com.mobile.model.UserCredential;
**/
import com.schoolsupplies.model.Register;

@Repository
public class RegisterDAO 
{
	
	@Autowired
	SessionFactory sessionFactory;
	
	public void addUser(Register r)
	{
		System.out.println("Register DAO");
		
		System.out.println("NAME =" + r.getName());
		System.out.println("UserName = " + r.getUsername());
		System.out.println("pass = " + r.getPassword());
		System.out.println("Mobile = " + r.getMobno());
		System.out.println("email = " + r.getEmail());
		
		/**
		UserCredential uc=new UserCredential();
				
		uc.setUsername(r.getUsername());
		uc.setPassword(r.getPassword());
		System.out.println("User Credentials");
		**/
		
		try
		{
		Session session= sessionFactory.openSession();
		System.out.println("after openSession...");
		Transaction tx=session.beginTransaction();
		System.out.println("after calling session.begin txn..");

//tx.commit();

		//tx.begin();
		//System.out.println(" tx.begin() Over...");
		
		session.saveOrUpdate(r);
		System.out.println(" session.save(r) Over...");
		
		/**
		session.save(uc);
		**/
		
		tx.commit();
		System.out.println(" tx.commit over");
		
		session.flush();
		System.out.println("after flush..");
		
		session.close();
		System.out.println("session closed...");
		
		}
		catch(Exception e)
		{
			System.out.println("Error:::"+e);
		}
	}
	
	public Register getInfo(String username)
	{
		
		Session session = sessionFactory.openSession();
	      Transaction tx = session.getTransaction();
	      
	      System.out.println("  In getInfo(String username)..");
	      tx.begin();
	      Register uc=(Register) session.get(Register.class,username);
	      System.out.println(uc);
	      tx.commit();
	      return uc;
	}
	
	
	
}
