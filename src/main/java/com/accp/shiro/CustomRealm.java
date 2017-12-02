package com.accp.shiro;

import java.util.Map;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;

import com.accp.dao.BizDao;
/**
 * @see 处理mapper ,dao中的验证方法 
 * */
public class CustomRealm extends AuthorizingRealm{

	private BizDao bizDao;
	
	public BizDao getBizDao() {
		return bizDao;
	}

	public void setBizDao(BizDao bizDao) {
		this.bizDao = bizDao;
	}

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection arg0) {//授权
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @param AuthenticationToken  令牌机制
	 * 计算机密码学   公钥  私钥
	 * */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {//验证
		// TODO Auto-generated method stub
		//得到一种用户名这种钥匙的东东
		String principal= token.getPrincipal().toString();
		System.out.println("principal:"+principal);
		Map<String, Object> user= bizDao.validateUser2(principal);
		if(user==null){
			return null;
		}else{
			//获取键：密码
			String pwd= (String)user.get("USERPASSWORD");
			System.out.println("密码："+pwd);
			Subject sub=SecurityUtils.getSubject();
			sub.getSession().setAttribute("User",user);
			SimpleAuthenticationInfo info=new SimpleAuthenticationInfo(user, pwd, getName());//给用户名进行授权
			return info;
		}
		
	}

}
