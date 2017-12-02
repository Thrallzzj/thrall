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
 * @see ����mapper ,dao�е���֤���� 
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
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection arg0) {//��Ȩ
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @param AuthenticationToken  ���ƻ���
	 * ���������ѧ   ��Կ  ˽Կ
	 * */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {//��֤
		// TODO Auto-generated method stub
		//�õ�һ���û�������Կ�׵Ķ���
		String principal= token.getPrincipal().toString();
		System.out.println("principal:"+principal);
		Map<String, Object> user= bizDao.validateUser2(principal);
		if(user==null){
			return null;
		}else{
			//��ȡ��������
			String pwd= (String)user.get("USERPASSWORD");
			System.out.println("���룺"+pwd);
			Subject sub=SecurityUtils.getSubject();
			sub.getSession().setAttribute("User",user);
			SimpleAuthenticationInfo info=new SimpleAuthenticationInfo(user, pwd, getName());//���û���������Ȩ
			return info;
		}
		
	}

}
