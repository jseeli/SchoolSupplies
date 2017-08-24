package com.schoolsupplies.dao;


import java.util.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
import com.google.gson.Gson;
import com.mobile.model.Category;
import com.mobile.model.Product;
import com.mobile.model.Seller;
***/

import com.schoolsupplies.model.Supplier;

@Transactional
@Repository
public class SupplierDAO
{
	
	@Autowired
	SessionFactory sessionFactory;
	
	public void addSupplier(Supplier s)
	{
	
		
		System.out.println("In add sid: " + s.getSid());
		System.out.println("In add sname: " + s.getSname());
				
		try
		{
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		session.save(s);
		tx.commit();
		session.flush();
		session.close();
		}
		
		catch(Exception e)
		{
			System.out.println("Error"+e);
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Supplier> showSupplier()
	{
		
		System.out.println("In show...");
		
		Session session 	= sessionFactory.openSession();
		Transaction tx 		= session.getTransaction();
		
		tx.begin();
		
		List<Supplier> showsupp = session.createQuery("from Supplier").list();
				
				//for(Supplier s : showsupp){
				//	System.out.println("List of Suppliers::" + s.getSname() + " , " + s.getSid());
				//}
						
		//System.out.println("In showsupp...after createQuery(from Supplier).list");

		
		tx.commit();
		
		System.out.println("In showSupp...after tx.commit()");
		
		/**
		session.flush();
		session.close();
		**/
		
		return showsupp;
	}
	
	public Supplier showSupplier(int showsupp)
	{
		Session session = sessionFactory.openSession();
	      Transaction tx = session.getTransaction();
	      tx.begin();
	      Supplier s = (Supplier) session.get(Supplier.class, showsupp);
	      tx.commit();
	      session.flush();
	    session.close();
	      return s;
		
	}
	
/***	
	public String[] showcatseller()
	{
		Session session=sessionFactory.openSession();
		Transaction tx=session.getTransaction();
		tx.begin();
		List showcat=session.createQuery("from Category").list();
		List showsel=session.createQuery("from Seller").list();
		tx.commit();
		session.flush();
		session.clear();
		Gson g=new Gson();
		String[] cat=new String[2];
		cat[0]=g.toJson(showcat);
		cat[1]=g.toJson(showsel);
		session.close();
		return cat;
		
	}
	
	public void editProduct(Product editprod)
	{
		
		Session s=sessionFactory.openSession();
	    Transaction tx=s.getTransaction();
		tx.begin();
		Product p=(Product)s.get(Product.class,editprod.getPid());
		p.setPquan(editprod.getPquan());
		p.setPcost(editprod.getPcost());
		s.update(p);
		tx.commit();
		System.out.println("8");
		s.close();
		
	}
	public void deleteProduct(int delprodid)
	{
		System.out.println("0");
		Session session = sessionFactory.openSession();
		System.out.println("1");
	      Transaction tx = session.getTransaction();
	      System.out.println("2");
	      tx.begin();
	      System.out.println("3");
	        Product p=(Product)session.get(Product.class,delprodid);
	        System.out.println("3");
	        System.out.println(p);
	         session.delete(p); 
	         System.out.println("3");
	         tx.commit();
	}
	
	**/
	
	
}

	
	
	

