package com.accp.pojo;

import java.math.BigDecimal;
import java.util.Date;

/**
 * SmbmsBill entity. @author MyEclipse Persistence Tools
 */
//多方  实体类是世界 作为临时仓库
public class SmbmsBill implements java.io.Serializable {

	// Fields

	private Integer id;
	private String billcode;
	private String productname;
	private String productdesc;
	private String productunit;
	private BigDecimal productcount;
	private Double totalprice;
	private Long ispayment;
	private String createdby;
	private Date creationdate;
	private String modifyby;
	private Date modifydate;
	
	private SmbmsProvider pid;
	
	//private Integer pid;
	
	
//	public Integer getPid() {
//		return pid;
//	}
//
//	public void setPid(Integer pid) {
//		this.pid = pid;
//	}

	public SmbmsProvider getPid() {
		return pid;
	}

	public void setPid(SmbmsProvider pid) {
		this.pid = pid;
	}

	//private BigDecimal providerid;
	private SmbmsProvider spro;//类  
	
	// Constructors

	public SmbmsProvider getSpro() {
		return spro;
	}

	public void setSpro(SmbmsProvider spro) {
		this.spro = spro;
	}

	/** default constructor */
	public SmbmsBill() {
	}

	/** minimal constructor */
	public SmbmsBill(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public SmbmsBill(Integer id, String billcode, String productname,
			String productdesc, String productunit, BigDecimal productcount,
			Double totalprice, Long ispayment, String createdby,
			Date creationdate, String modifyby, Date modifydate,
			BigDecimal providerid) {
		this.id = id;
		this.billcode = billcode;
		this.productname = productname;
		this.productdesc = productdesc;
		this.productunit = productunit;
		this.productcount = productcount;
		this.totalprice = totalprice;
		this.ispayment = ispayment;
		this.createdby = createdby;
		this.creationdate = creationdate;
		this.modifyby = modifyby;
		this.modifydate = modifydate;
		//this.providerid = providerid;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBillcode() {
		return this.billcode;
	}

	public void setBillcode(String billcode) {
		this.billcode = billcode;
	}

	public String getProductname() {
		return this.productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public String getProductdesc() {
		return this.productdesc;
	}

	public void setProductdesc(String productdesc) {
		this.productdesc = productdesc;
	}

	public String getProductunit() {
		return this.productunit;
	}

	public void setProductunit(String productunit) {
		this.productunit = productunit;
	}

	public BigDecimal getProductcount() {
		return this.productcount;
	}

	public void setProductcount(BigDecimal productcount) {
		this.productcount = productcount;
	}

	public Double getTotalprice() {
		return this.totalprice;
	}

	public void setTotalprice(Double totalprice) {
		this.totalprice = totalprice;
	}

	public Long getIspayment() {
		return this.ispayment;
	}

	public void setIspayment(Long ispayment) {
		this.ispayment = ispayment;
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

	public String getModifyby() {
		return this.modifyby;
	}

	public void setModifyby(String modifyby) {
		this.modifyby = modifyby;
	}

	public Date getModifydate() {
		return this.modifydate;
	}

	public void setModifydate(Date modifydate) {
		this.modifydate = modifydate;
	}

//	public BigDecimal getProviderid() {
//		return this.providerid;
//	}
//
//	public void setProviderid(BigDecimal providerid) {
//		this.providerid = providerid;
//	}

}