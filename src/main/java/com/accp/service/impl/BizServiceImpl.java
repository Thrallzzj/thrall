package com.accp.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accp.dao.BizDao;
import com.accp.pojo.Product;
import com.accp.pojo.SmbmsBill;
import com.accp.pojo.SmbmsProvider;
import com.accp.pojo.SmbmsUser;
import com.accp.service.BizService;
@Service("bs")
public class BizServiceImpl implements BizService{
	@Autowired
	private BizDao bizDao;
	
	public BizDao getBizDao() {
		return bizDao;
	}

	public void setBizDao(BizDao bizDao) {
		this.bizDao = bizDao;
	}

	public List<SmbmsUser> validateUser(HashMap map) {
		// TODO Auto-generated method stub
		return bizDao.validateUser(map);
	}

	public List<HashMap> getAllSmbmsBill() {
		// TODO Auto-generated method stub
		return bizDao.getAllSmbmsBill();
	}

	public List<SmbmsProvider> getProviderName() {
		// TODO Auto-generated method stub
		return bizDao.getProviderName();
	}

	public List<SmbmsBill> getSmbmsBillIsPayment() {
		// TODO Auto-generated method stub
		return bizDao.getSmbmsBillIsPayment();
	}

	public List<HashMap> getAllSmbmsBillByTj(Product product) {
		// TODO Auto-generated method stub
		return bizDao.getAllSmbmsBillByTj(product);
	}

	public List<HashMap> getAllSmbmsBillByTj2(Product product) {
		// TODO Auto-generated method stub
		return bizDao.getAllSmbmsBillByTj2(product);
	}

	public Map<String, Object> validateUser2(String name) {
		// TODO Auto-generated method stub
		return bizDao.validateUser2(name);
	}

	

}
