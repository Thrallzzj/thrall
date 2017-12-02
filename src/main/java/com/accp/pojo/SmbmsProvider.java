package com.accp.pojo;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * SmbmsProvider entity. @author MyEclipse Persistence Tools
 */
//Ò»·½
public class SmbmsProvider implements java.io.Serializable {

	// Fields

	private BigDecimal id;
	private String procode;
	private String proname;
	private String prodesc;
	private String procontact;
	private String prophone;
	private String proaddress;
	private String profax;
	private String createdby;
	private Date creationdate;
	private Date modifydate;
	private String modifyby;
	
	
	// Constructors
	/** default constructor */
	public SmbmsProvider() {
	}

	/** minimal constructor */
	public SmbmsProvider(BigDecimal id) {
		this.id = id;
	}

	/** full constructor */
	public SmbmsProvider(BigDecimal id, String procode, String proname,
			String prodesc, String procontact, String prophone,
			String proaddress, String profax, String createdby,
			Date creationdate, Date modifydate, String modifyby) {
		this.id = id;
		this.procode = procode;
		this.proname = proname;
		this.prodesc = prodesc;
		this.procontact = procontact;
		this.prophone = prophone;
		this.proaddress = proaddress;
		this.profax = profax;
		this.createdby = createdby;
		this.creationdate = creationdate;
		this.modifydate = modifydate;
		this.modifyby = modifyby;
	}

	// Property accessors

	public BigDecimal getId() {
		return this.id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}

	public String getProcode() {
		return this.procode;
	}

	public void setProcode(String procode) {
		this.procode = procode;
	}

	public String getProname() {
		return this.proname;
	}

	public void setProname(String proname) {
		this.proname = proname;
	}

	public String getProdesc() {
		return this.prodesc;
	}

	public void setProdesc(String prodesc) {
		this.prodesc = prodesc;
	}

	public String getProcontact() {
		return this.procontact;
	}

	public void setProcontact(String procontact) {
		this.procontact = procontact;
	}

	public String getProphone() {
		return this.prophone;
	}

	public void setProphone(String prophone) {
		this.prophone = prophone;
	}

	public String getProaddress() {
		return this.proaddress;
	}

	public void setProaddress(String proaddress) {
		this.proaddress = proaddress;
	}

	public String getProfax() {
		return this.profax;
	}

	public void setProfax(String profax) {
		this.profax = profax;
	}

	public String getCreatedby() {
		return this.createdby;
	}

	public void setCreatedby(String createdby) {
		this.createdby = createdby;
	}

	public Date getCreationdate() {
		return this.creationdate;
	}

	public void setCreationdate(Date creationdate) {
		this.creationdate = creationdate;
	}

	public Date getModifydate() {
		return this.modifydate;
	}

	public void setModifydate(Date modifydate) {
		this.modifydate = modifydate;
	}

	public String getModifyby() {
		return this.modifyby;
	}

	public void setModifyby(String modifyby) {
		this.modifyby = modifyby;
	}

}