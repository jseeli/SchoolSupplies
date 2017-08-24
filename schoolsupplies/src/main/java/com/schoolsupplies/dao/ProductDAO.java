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

import com.schoolsupplies.model.Product;

@Transactional
@Repository
public class ProductDAO
{
	
	@Autowired
	SessionFactory sessionFactory;
	
	public void addProduct(Product p)
	{
	
		
		System.out.println("In addProduct name : " + p.getPname());
		
		System.out.println("In addProduct file : " + (p.getPimage().getOriginalFilename()));
		//[INFO] Copying webapp resources [E:\Eclipse\Jaya-Dev\ScSuppWS\schoolsupplies\src\main\webapp]

						
		try
		{
			Session session=sessionFactory.openSession();
			System.out.println("addproduct: session opened");;
			Transaction tx=session.beginTransaction();
			System.out.println("addproduct:session Xn begun");;

			session.save(p);
			System.out.println("addproduct: session saved");;

			tx.commit();
			
			System.out.println("addproduct: commit over");;

			session.flush();
			
			System.out.println("addproduct: session flushed");;

			session.close();
			
			System.out.println("addproduct: session closed");;

		}
		catch(Exception e)
		{
			System.out.println("Error"+e);
		}
		
		System.out.println(" addProduct DONE");
	}
	
	@SuppressWarnings("unchecked")
	public List<Product> showProduct()
	{

		System.out.println("In showProduct...");

		Session session=sessionFactory.openSession();
		Transaction tx=session.getTransaction();
		tx.begin();
		List<Product> showprod=session.createQuery("from Product").list();

		//for(Product p : showprod){
		//	System.out.println("List of products::name = " + p.getPname() + "   categ=  " + p.getCategory() + "   supp =  " + p.getSupplier());
		//}

		tx.commit();

		/**
		session.flush();
		session.close();
		 **/

		return showprod;
	}

	public Product showProduct(int showprod)
	{
		System.out.println("In showProduct... showprod = " + showprod);
		
		
		Session session = sessionFactory.openSession();
		Transaction tx = session.getTransaction();
		
		System.out.println("In showProduct..getTransaction over"); 
		
		tx.begin();
		
		System.out.println("In showProduct..tx.begin over"); 

		
		Product p=(Product)session.get(Product.class,showprod);
		
		System.out.println("In showProduct..session get over pname = " + p.getPname()); 

		tx.commit();
		
		System.out.println("In showProduct..commit over"); 

		//session.flush();
		session.close();
		return p;

	}
	
	
	public void deleteProduct(int delprodid)
	{
		System.out.println("In dao - deleteproduct()...");
		Session session = sessionFactory.openSession();
		Transaction tx = session.getTransaction();
		tx.begin();

		Product p=(Product)session.get(Product.class,  delprodid);

		System.out.println(" In delete Product... delprodid= " + delprodid + "  p.pname = " + p.getPname() );

		session.delete(p); 

		System.out.println("deleteproduct : Deleted...");

		tx.commit();
		

	}
	
	
	public void editProduct(Product editprod)
	{
		System.out.println("In dao - editproduct()...");

		Session s=sessionFactory.openSession();
		
	    Transaction tx=s.getTransaction();
	    
		tx.begin();
		System.out.println("In dao - editproduct()...tx.begin over");

		
		Product p=(Product)s.get(Product.class,editprod.getPid());
		
		System.out.println("In dao - editproduct()...s.get over ");

		
		p.setPquan(editprod.getPquan());
		
		p.setPcost(editprod.getPcost());
		
		System.out.println("In dao - editproduct()...new values set");

		
		s.update(p);
		
		System.out.println("In dao - editproduct(). update  OVER..");

		
		tx.commit();
		
		System.out.println("8");
		
		s.close();
		
		
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

	
	
	

