package com.accp.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.accp.pojo.Product;
import com.accp.pojo.SmbmsBill;
import com.accp.pojo.SmbmsProvider;
import com.accp.pojo.SmbmsUser;

public interface BizDao {
	List<SmbmsUser> validateUser(HashMap map);
	Map<String, Object> validateUser2(String name);
	List<HashMap> getAllSmbmsBill();
	List<SmbmsProvider> getProviderName();
	
	List<SmbmsBill> getSmbmsBillIsPayment();
	
	List<HashMap> getAllSmbmsBillByTj(Product product);
//	
	List<HashMap> getAllSmbmsBillByTj2(Product product);
}
