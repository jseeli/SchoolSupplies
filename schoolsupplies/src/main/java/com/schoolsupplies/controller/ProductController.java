
package com.schoolsupplies.controller;



import java.io.BufferedOutputStream;
//import java.io.File;
import java.io.FileOutputStream;
//import java.io.File;
import java.io.IOException;

import java.util.ArrayList;
/**
import java.util.Collection;
**/

import javax.servlet.http.HttpServletRequest;

/****
import javax.servlet.http.HttpSession;
****/
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;


import com.schoolsupplies.dao.ProductDAO;
import com.schoolsupplies.dao.CategoryDAO;
import com.schoolsupplies.dao.SupplierDAO;

import com.google.gson.Gson;


import com.schoolsupplies.model.Product;
import com.schoolsupplies.model.Category;
import com.schoolsupplies.model.Supplier;


@Controller
public class ProductController {
	
	@Autowired(required=true)
	ProductDAO pdao;
	
	@Autowired(required=true)
	CategoryDAO cdao;
	
	@Autowired(required=true)
	SupplierDAO sdao;


	@RequestMapping(value="/product", method=RequestMethod.GET)
	public ModelAndView showproduct(@ModelAttribute("product")Product product, Model m)
	//public ModelAndView showproduct(@ModelAttribute("product")Product product)

	{
			System.out.println("/product... ");	
			ModelAndView mv=new ModelAndView("product");
			
			ArrayList<Category> catList=(ArrayList<Category>)cdao.showCategory();
			m.addAttribute("catList",catList);
			
			ArrayList<Supplier> suppList=(ArrayList<Supplier>)sdao.showSupplier();
			m.addAttribute("suppList",suppList);
			
			//m.addAttribute("temp", "SOMESTRING");
			
			System.out.println("/product... GET... b4 return...");
			return mv;
	}
	
	@RequestMapping(value="/saveproduct", method=RequestMethod.POST)
	//public ModelAndView saveproduct(@ModelAttribute("product")Product prod, Model m)
	public ModelAndView saveproduct(HttpServletRequest request,  @ModelAttribute("product")Product prod )

	{		
			System.out.println(" /savproduct POST");
				
			String filecontextpath=request.getSession().getServletContext().getContextPath();
			System.out.println("File context path =" + filecontextpath);
						
			// @@@@@@String filepath=request.getSession().getServletContext().getRealPath("/");
			//@@@@@@System.out.println("File real path =" + filepath);	
			
			// Image file
			MultipartFile file = prod.getPimage();
			
			String filename = file.getOriginalFilename();
			System.out.println("Filename =" + filename);
			
			prod.setImgname(filename);
			
			//[INFO] Copying webapp resources [E:\Eclipse\Jaya-Dev\ScSuppWS\schoolsupplies\src\main\webapp]
			//File context path =/schoolsupplies
			//		File real path =E:\Eclipse\Jaya-Dev\ScSuppWS\.metadata\.plugins\org.eclipse.wst.server.core\tmp2\wtpwebapps\schoolsupplies\
			//		Filename =VMChurch1.jpg
			String filepath = "E:\\Eclipse\\Jaya-Dev\\ScSuppWS\\schoolsupplies\\src\\main\\webapp\\resources\\images";
			System.out.println("File real path =" + filepath);	


			
			// Insert the entered product details to the product table
			
			pdao.addProduct(prod);

			// Upload Image file
			
			System.out.println("File Path and filename  " + filepath + "          " + filename);
			
			try {
				byte	imagebyte[] = file.getBytes();
				
				System.out.println("  imagebyte.length = " +   imagebyte.length);
				
				//BufferedOutputStream fos = new BufferedOutputStream( new FileOutputStream(filepath+"resources/"+filename) );
				BufferedOutputStream fos = new BufferedOutputStream( new FileOutputStream(filepath+"/"+filename) );

				// Write data to file in server :: write images in bytes
				
				fos.write(imagebyte);
				fos.close();
				
				System.out.println("File Uploaded Successfully");
								
			} catch (IOException e)
			{
				e.printStackTrace();
				
			} catch (Exception e)
			{
				e.printStackTrace();
			}
			
					
			System.out.println(" after pdao.addProduct... /saveproduct POST... ");	

			ModelAndView mv=new ModelAndView("admin","Product", new Product());
			return mv;
	}
	

	@RequestMapping(value="/viewproducts",method=RequestMethod.GET)
	public ModelAndView viewProduct1(Model m)
	{
		
		System.out.println(" In /viewproducts... GET... ");
		
		ArrayList<Product> pList=(ArrayList<Product>)pdao.showProduct();
		
		//for(Product p : pList){
		//	System.out.println("List of products::"+p.getCategory()+","+p.getSupplier());
		//}

		m.addAttribute("pList",pList);
		
		ModelAndView mv=new ModelAndView("viewproducts","Product",new Product());
		
		return mv;
	}
		
	//@RequestMapping(value="/delProduct",method=RequestMethod.GET)
	//public ModelAndView DeleteProduct(@RequestParam("pid")int pid, Model m)
	@RequestMapping("/delProduct/{pid}")
	public ModelAndView deleteProduct(@PathVariable("pid") int pid, Model m)
	{
		System.out.println(" In /delProduct... GET...   pid = " + pid);
		
		pdao.deleteProduct(pid);

		//m.addAttribute("list",getdata());
		ArrayList<Product> pList=(ArrayList<Product>)pdao.showProduct();
		m.addAttribute("pList",pList);
		
		for(Product p : pList){
			System.out.println("After delete ::products:: name = "+p.getPname()  + " cat = "+p.getCategory());
		}

		ModelAndView mv=new ModelAndView("viewproducts","Product",new Product());
		return mv;
		//return "redirect:/viewproducts?del" ;
	}
	
	@RequestMapping(value="/updateproduct/{pid}",method=RequestMethod.GET)
	//public ModelAndView updateproduct(@RequestParam("pid")int pid,Model m) 
	public ModelAndView updateproduct(@PathVariable("pid") int pid, Model m)
	{
		System.out.println("In /updateproduct ... GET");;
		
		Product p=pdao.showProduct(pid);
		m.addAttribute("EditProduct1",p);
		ModelAndView mv=new ModelAndView("updateproduct","Product",new Product());
		return mv;

	}
	
	public String getdata()
	{
		ArrayList<Product> list=(ArrayList<Product>)pdao.showProduct();
		Gson gson = new Gson();
		String jsonInString = gson.toJson(list);
		return jsonInString;
	}
	
	
	@RequestMapping(value="/updateproduct", method=RequestMethod.POST)
	//public ModelAndView updateproduct(Product prod, Model m)
	//public ModelAndView updateproduct(HttpServletRequest request, @ModelAttribute("EditProduct1")Product prod, Model m) 
	public ModelAndView updateproduct(Product prod, Model m) 
	{
		System.out.println("In /updateproduct ... POST");;

		
		pdao.editProduct(prod);
		System.out.println("In /updateproduct ... POST.. editproduct over");;

		m.addAttribute("pList",getdata());
		
		System.out.println("In /updateproduct ... POST addattribute over");;

		ModelAndView mv=new ModelAndView("viewproducts","Product",new Product());
		return mv;

	}

	
	/****   Code for Category ---  Begins ****/
	
	@RequestMapping(value="/category", method=RequestMethod.GET)
	public ModelAndView showcategory(@ModelAttribute("category")Category category)
	{
			System.out.println("/category... showcategory()");
						
			ModelAndView model=new ModelAndView("category");
			//System.out.println("/category... GET... b4 return...");
			
			return model;
	}
	
	
	@RequestMapping(value="/savecategory", method=RequestMethod.POST)
	public ModelAndView savecategory(@ModelAttribute("category")Category cat, Model m)
	//public ModelAndView savecategory(HttpServletRequest request, @ModelAttribute("category")Category cat, Model m)

	{
			System.out.println(" /savecategory .....ProductController... POST");	
			
			cdao.addCategory(cat);
			
			//System.out.println(" after pdao.addCategory... /savecategory POST... ");	

			ModelAndView model=new ModelAndView("admin","Category", new Category());
			return model;
	}
	

	@RequestMapping(value="/viewcategories",method=RequestMethod.GET)
	public ModelAndView viewcategories(Model m)
	{
		
		System.out.println(" In /viewcategories... GET... ");
		
		ArrayList<Category> list=(ArrayList<Category>)cdao.showCategory();
		
		//System.out.println(" after pdao.showCategory... /viewcategories   GET... ");
		//for(Category c : list){
		//	System.out.println("List of Categories::"+c.getCname()+","+c.getCid());
		//}
		
		m.addAttribute("list",list);
		
		ModelAndView mv=new ModelAndView("viewcategories","Category",new Category());
		
		return mv;
	}
	
	/****   Category Ends ***/
	
	/****  Supplier Begins ***/
	
	@RequestMapping(value="/supplier", method=RequestMethod.GET)
	public ModelAndView showsupplier(@ModelAttribute("supplier")Supplier supplier)
	{
			System.out.println("/supplier... ProductController.ModelAndView showsupplier()");	
			ModelAndView model=new ModelAndView("supplier");
			//System.out.println("/suplier... GET... b4 return...");
			return model;
	}
	
	
	@RequestMapping(value="/savesupplier", method=RequestMethod.POST)
	public ModelAndView savesupplier(@ModelAttribute("supplier")Supplier supp, Model m)
	{
			System.out.println(" /savesupplier .....ProductController... POST");	

			sdao.addSupplier(supp);
			
			//System.out.println(" after sdao.addsupplier... /savePOST... ");	

			ModelAndView model=new ModelAndView("admin","Supplier", new Supplier());
			return model;
	}
	

	@RequestMapping(value="/viewsuppliers",method=RequestMethod.GET)
	public ModelAndView viewsuppliers(Model m)
	{
		
		System.out.println(" In /viewcategories... GET... ");
		
		ArrayList<Supplier> list=(ArrayList<Supplier>)sdao.showSupplier();
		
		//System.out.println(" after sdao.showSupplier... /viewGET... ");
		//for(Supplier s : list){
		//	System.out.println("List of Suppliers::" + s.getSname() + "," + s.getSid());
		//}
		
		m.addAttribute("list",list);
		
		ModelAndView mv=new ModelAndView("viewsuppliers","Supplier",new Supplier());
		
		return mv;
	}
		
	/****  Supplier Ends ***/
		
}
	


/***************************
 * 
package com.mobile.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.google.gson.Gson;
import com.mobile.dao.ProductDAO;
import com.mobile.model.Product;


@Controller
public class ProductController 
{
	@Autowired
	ProductDAO pdao;

	
	public String getdata()
	{
		ArrayList list=(ArrayList)pdao.showProduct();
		Gson gson = new Gson();
		String jsonInString = gson.toJson(list);
		return jsonInString;
	}
	

	@RequestMapping(value="/AddProduct",method=RequestMethod.GET)
	public ModelAndView addProduct(Model m)
	{
		String[] s=pdao.showcatseller();
		System.out.println(s[0]);
		m.addAttribute("catlist",s[0]);
		m.addAttribute("selllist",s[1]);		
		ModelAndView mv=new ModelAndView("AddProduct","prdt",new Product());
		return mv;

	
	}
	

	@RequestMapping(value="/AddProduct",method=RequestMethod.POST)
	public ModelAndView addproduct(@ModelAttribute("prdt")Product prdt, HttpServletRequest request,RedirectAttributes attributes,Model m)
	{
		System.out.println("Controller called");
		
		System.out.println(prdt.getPid());
		pdao.addProduct(prdt);
	
		String path="C:\Users\MRuser\Desktop\MobileCafe_New-master\MobileCafe\\src\\main\\webapp\\resources\\images\\";
		path=path+String.valueOf(prdt.getPid())+".jpg";
		System.out.println(path);
		File f=new File(path);
		MultipartFile filedet=prdt.getPimage();
		
		if(!filedet.isEmpty())
		{
			try
			{
			  byte[] bytes=filedet.getBytes();
			  System.out.println(bytes.length);
			  FileOutputStream fos=new FileOutputStream(f);
              			BufferedOutputStream bs=new BufferedOutputStream(fos);
              			bs.write(bytes);
              			bs.close();
             			 System.out.println("File Uploaded Successfully");
			}
			catch(Exception e)
			{
				System.out.println("Exception Arised"+e);
			}
		}
		else
		{
			System.out.println("File is Empty not Uploaded");
			
		}
		m.addAttribute("list",getdata());
		ModelAndView mv=new ModelAndView("ViewProduct","Product",new Product());
		return mv;
 
	
	}
	

	@RequestMapping(value="/ViewProduct",method=RequestMethod.GET)
	public ModelAndView viewProduct1(Model m)
	{
		m.addAttribute("list",getdata());
		ModelAndView mv=new ModelAndView("ViewProduct","Product",new Product());
		return mv;
	}
	
	
	@RequestMapping(value="/FullProduct",method=RequestMethod.GET)
	public String userview(Model m)
	{
		System.out.println("Hello");
		System.out.println(getdata());
		m.addAttribute("list",getdata());
		return "FullProduct";
	}
	

	@RequestMapping(value="/ProductDescription",method=RequestMethod.GET)
	public ModelAndView viewdescrp(@RequestParam("id")int pid,Model m)
	{
		System.out.println("Hello");
		//System.out.println(pid);
		Product p=pdao.showProduct(pid);
		Gson gson = new Gson();
		String list=gson.toJson(p);
		m.addAttribute("list1",list);
	    ModelAndView mv=new ModelAndView("ProductDescription","Product",new Product());
		return mv;
		//	System.out.println(getdata());
		
	}
	

	@RequestMapping(value="/AddToCart",method=RequestMethod.GET)
	public ModelAndView addtocart(@RequestParam("addpid")int pid,Model m)
	{
		System.out.println("Hello");
		//System.out.println(pid);
		Product p=pdao.showProduct(pid);
		Gson gson = new Gson();
		String list=gson.toJson(p);
		m.addAttribute("list1",list);
	    ModelAndView mv=new ModelAndView("AddToCart","Product",new Product());
		return mv;
		//	System.out.println(getdata());
		
	}
	
	@RequestMapping(value="/EditProduct",method=RequestMethod.GET)
	public ModelAndView editproduct(@RequestParam("id")int pid,Model m) 
	{
		Product p=pdao.showProduct(pid);
		m.addAttribute("EditProduct1",p);
		ModelAndView mv=new ModelAndView("EditProduct","EditProduct",new Product());
		return mv;

	}
	
	//Getting values from Category Page
	@RequestMapping(value="/EditProduct",method=RequestMethod.POST)
	public ModelAndView editproduct(Product typepro,Model m) 
	{
		pdao.editProduct(typepro);
		m.addAttribute("list",getdata());
		ModelAndView mv=new ModelAndView("ViewProduct","Product",new Product());
		return mv;

	}

	@RequestMapping(value="/delProduct",method=RequestMethod.GET)
	public ModelAndView DeleteProduct(@RequestParam("id")int pid,Model m)
	
	{
		pdao.deleteProduct(pid);
		m.addAttribute("list",getdata());
		ModelAndView mv=new ModelAndView("ViewProduct","ViewProduct",new Product());
		return mv;
	}
	


}

***********************************/