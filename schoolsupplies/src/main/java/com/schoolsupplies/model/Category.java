package com.schoolsupplies.model;

import javax.persistence.Column;
import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;
**/

@Entity
@Table(name="Category")
public class Category 
{
	@Id
	// @GeneratedValue(strategy=GenerationType.AUTO)
	private int cid;
	
	@Column
	private String cname;
	
	public  Category()
	{
		    System.out.println("In Category Constructor...");
		    
	}
	
	
	/**
	 * @return the cid
	 */
	public int getCid() {
		return cid;
	}


	/**
	 * @param cid the cid to set
	 */
	public void setCid(int cid) {
		this.cid = cid;
	}


	/**
	 * @return the cname
	 */
	public String getCname() {
		return cname;
	}


	/**
	 * @param cname the cname to set
	 */
	public void setCname(String cname) {
		this.cname = cname;
	}

	
		
	
}
