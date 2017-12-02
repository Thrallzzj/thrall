package com.accp.web;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.accp.pojo.Product;
import com.accp.pojo.SmbmsBill;
import com.accp.pojo.SmbmsProvider;
import com.accp.pojo.SmbmsUser;
import com.accp.service.BizService;
import com.accp.util.JsonUtil;
@Controller
public class BizAction {
	@Autowired
	private BizService bs;
	
	public BizService getBs() {
		return bs;
	}

	public void setBs(BizService bs) {
		this.bs = bs;
	}

	@RequestMapping("/login.action")
	public String validate(@RequestParam("userCode") String userCode,@RequestParam("userPassword") String userPassword,HttpServletRequest request) throws Exception{
		HashMap map=new HashMap();
		map.put("uname", userCode);
		map.put("upwd", userPassword);
		List<SmbmsUser> list= bs.validateUser(map);
		if(list.size()>0){
			return "jsp/frame.jsp";
		}else{
			return "error.jsp";
		}
		
		
		
	}
	@RequestMapping("/login2.action")
	public String validate2(HttpServletRequest request,Model model){
		Subject sub=SecurityUtils.getSubject();
		String userCode= request.getParameter("userCode");
		String userPassword= request.getParameter("userPassword");
		UsernamePasswordToken token=new UsernamePasswordToken(userCode, userPassword);
		try {
			sub.login(token);
			return "/bill.action";//密匙配对成功
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return "error.jsp";
		}
	}
	
	
	@RequestMapping("/bill.action")
	public String getAllBill(Model model) throws Exception{
		List<HashMap> listsb= bs.getAllSmbmsBill();
		List<SmbmsProvider> listsp= bs.getProviderName();
		List<SmbmsBill> listbs= bs.getSmbmsBillIsPayment();
		model.addAttribute("listsb",listsb);
		model.addAttribute("listsp", listsp);
		model.addAttribute("listbs", listbs);
		return "jsp/billlist.jsp";
	}
	@RequestMapping(value="/ajax.action" ,produces="application/json;charset=utf-8")
	public @ResponseBody String ajaxAction(@RequestParam("pro") String pro,HttpServletResponse response) throws Exception{
		System.out.println("pro:"+pro);
		Product product= (Product)JsonUtil.getObject4JsonString(pro, Product.class);
		System.out.println("product.getProname():"+product.getProname());
		System.out.println("product.getPid():"+product.getPid());
		System.out.println("product.getIspay():"+product.getIspay());
		List<HashMap> listmap= bs.getAllSmbmsBillByTj(product);
		JSONArray jarray= JSONArray.fromObject(listmap);
		
		return jarray.toString();
	}
	@RequestMapping("/ajax2.action")
	public String ajaxAction2(@RequestParam("pro") String pro,Model model){
		System.out.println("今天天气好");
		System.out.println("pro:"+pro);
		Product product= (Product)JsonUtil.getObject4JsonString(pro, Product.class);
		System.out.println("product.getProname():"+product.getProname());
		System.out.println("product.getPid():"+product.getPid());
		System.out.println("product.getIspay():"+product.getIspay());
		List<HashMap> listsb= bs.getAllSmbmsBillByTj2(product);
		model.addAttribute("listsb",listsb);
		return "jsp/billlist.jsp";
	}
	
	
}
