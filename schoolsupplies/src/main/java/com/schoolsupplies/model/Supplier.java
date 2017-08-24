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
@Table(name="Supplier")
public class Supplier 
{
	@Id
	// @GeneratedValue(strategy=GenerationType.AUTO)
	private int sid;
	
	@Column
	private String sname;

	public Supplier() {
		System.out.println("Supplier Constructor called...");
	}

	/**
	 * @return the sid
	 */
	public int getSid() {
		return sid;
	}

	/**
	 * @param sid the sid to set
	 */
	public void setSid(int sid) {
		this.sid = sid;
	}

	/**
	 * @return the sname
	 */
	public String getSname() {
		return sname;
	}

	/**
	 * @param sname the sname to set
	 */
	public void setSname(String sname) {
		this.sname = sname;
	}
	
	
	
}
