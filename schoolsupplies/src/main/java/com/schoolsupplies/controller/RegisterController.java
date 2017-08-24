
package com.schoolsupplies.controller;




/***
import java.util.ArrayList;
import java.util.Collection;
***/

/****
import javax.servlet.http.HttpSession;
****/
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


import com.schoolsupplies.dao.RegisterDAO;
import com.schoolsupplies.model.Register;



@Controller
public class RegisterController {
	
	@Autowired(required=true)
	RegisterDAO rdao;
	

	
	/*******************
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/loginsuccess")
	public String login_session_attributes(HttpSession session,Model model) 
	{
		System.out.println("Hai..Am");
		
		String userid = SecurityContextHolder.getContext().getAuthentication().getName();
		
		Collection<GrantedAuthority> authorities = (Collection<GrantedAuthority>) SecurityContextHolder.getContext().getAuthentication().getAuthorities();
		String page="";
		
		String role="ROLE_USER";
		for (GrantedAuthority authority:authorities) 
		{
		 System.out.println(authority.getAuthority());
		     if (authority.getAuthority().equals(role)) 
		     {
		    	 
		    	 session.setAttribute("UserLoggedIn", "true");
		    	 session.setAttribute("Username", userid);
		    	 page="FullProduct";
		    	 ArrayList list=(ArrayList)pdao.showProduct();
		    	 Gson gson = new Gson();
		    	 String jsonInString=gson.toJson(list);
		    	 model.addAttribute("list",jsonInString);
		    	 ArrayList<Cart> cartitem=new ArrayList<Cart>();
		    	 session.setAttribute("mycart", cartitem);
		    	 
		    	 break;
		     }
		     else 
		     {
		    	 session.setAttribute("LoggedIn", "true");
		    	 session.setAttribute("Administrator", "true");
		    	 page="Admin";
		    	 break;
		    }
		}
		return page;
	}
	*******/

			
	@RequestMapping("/admin")
	public String showAdmin() 
	{
			System.out.println("admin Page...........");	
				return "admin";
	}
	
	@RequestMapping("/")
	public String index()
	{
		System.out.println("RegisterController.index()....");
	 return "index";
	}
	
	/**

	@RequestMapping("/register")
	public String register()
	{
		System.out.println("register page....");
	 return "register";
	}
	
	@RequestMapping("/Login")
	public String showLogin()
	{
		System.out.println("Login");
	 return "Login";
	}
	
	@RequestMapping("/forgotPassword")
	public String showForgetPassword()
	{
		System.out.println("forgotPassword");
	 return "forgotPassword";
	}
	
		***/

	@RequestMapping(value="/register", method=RequestMethod.GET)
	public ModelAndView showregister(@ModelAttribute("register")Register register)
	{
			System.out.println("/register... RegisterController showregister GET )");	
			ModelAndView model=new ModelAndView("register");
			
			System.out.println("/register... RegisterController showregister GET  just before return... )");	

			return model;
	}
	
	
	@RequestMapping(value="/saveregister", method=RequestMethod.POST)
	public ModelAndView saveregister(@ModelAttribute("register")Register reg, Model m)

	{
		
			System.out.println(" /saveregister .....RegisterController.ModelAndView saveregister(.......");	

			rdao.addUser(reg);
			
			System.out.println(" after rdao.addUser... /saveregister .....ModelAndView saveregister(.....");	

			ModelAndView model=new ModelAndView("index","Register", new Register());
			return model;
	}
	
	
}
	