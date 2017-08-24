package com.schoolsupplies.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import org.springframework.web.multipart.MultipartFile;


@Entity
@Table(name="Product")
public class Product 
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int pid;
	@Column
	private String pname;
	@Column
	private String supplier;
	@Column
	private String category;
	@Column
	private String pdesc;
	
	@Column
	int pquan;
	@Column
	int pcost;
	
	@Transient
	MultipartFile pimage;
	
	private String imgname;
	
	public Product()
	{
	System.out.println(" Product() Constructor... ");
	}
	
	
	
	/**
	 * @return the pid
	 */
	public int getPid() {
		return pid;
	}

	/**
	 * @param pid the pid to set
	 */
	public void setPid(int pid) {
		this.pid = pid;
	}

	/**
	 * @return the pname
	 */
	public String getPname() {
		return pname;
	}

	/**
	 * @param pname the pname to set
	 */
	public void setPname(String pname) {
		this.pname = pname;
	}

	/**
	 * @return the supplier
	 */
	public String getSupplier() {
		return supplier;
	}

	/**
	 * @param supplier the supplier to set
	 */
	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}

	/**
	 * @return the category
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * @param category the category to set
	 */
	public void setCategory(String category) {
		this.category = category;
	}

	/**
	 * @return the pdesc
	 */
	public String getPdesc() {
		return pdesc;
	}

	/**
	 * @param pdesc the pdesc to set
	 */
	public void setPdesc(String pdesc) {
		this.pdesc = pdesc;
	}

	/**
	 * @return the pquan
	 */
	public int getPquan() {
		return pquan;
	}

	/**
	 * @param pquan the pquan to set
	 */
	public void setPquan(int pquan) {
		this.pquan = pquan;
	}

	/**
	 * @return the pcost
	 */
	public int getPcost() {
		return pcost;
	}

	/**
	 * @param pcost the pcost to set
	 */
	public void setPcost(int pcost) {
		this.pcost = pcost;
	}

	/**
	 * @return the pimage
	 */
	public MultipartFile getPimage() {
		return pimage;
	}

	/**
	 * @param pimage the pimage to set
	 */
	public void setPimage(MultipartFile pimage) {
		this.pimage = pimage;
	}



	public String getImgname() {
		return imgname;
	}



	public void setImgname(String imgname) {
		this.imgname = imgname;
	}
		
}
