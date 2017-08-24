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

import com.schoolsupplies.model.Category;

@Transactional
@Repository
public class CategoryDAO
{
	
	@Autowired
	SessionFactory sessionFactory;
	
	public void addCategory(Category c)
	{
	
		
		System.out.println("In addCategory cid: " + c.getCid());
		System.out.println("In addcategory cname: " + c.getCname());
				
		try
		{
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		session.save(c);
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
	public List<Category> showCategory()
	{
		
		System.out.println("In showCategory...");
		
		Session session 	= sessionFactory.openSession();
		Transaction tx 		= session.getTransaction();
		
		tx.begin();
		
		List<Category> showcat = session.createQuery("from Category").list();
				
				//for(Category c : showcat){
				//	System.out.println("List of Categories::"+c.getCname()+","+c.getCid());
				//}
						
		//System.out.println("In showcat...after createQuery(from Category).list");

		
		tx.commit();
		
		System.out.println("In showCat...after tx.commit()");
		
		/**
		session.flush();
		session.close();
		**/
		
		return showcat;
	}
	
	public Category showCategory(int showcat)
	{
		Session session = sessionFactory.openSession();
	      Transaction tx = session.getTransaction();
	      tx.begin();
	      Category c=(Category)session.get(Category.class,showcat);
	      tx.commit();
	      session.flush();
	    session.close();
	      return c;
		
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

	
	
	

