/**
 * 文件名：com.zhang.shiro.realm.BaseRealm.java<br/>
 * 创建时间：2016年5月24日 下午4:26:37<br/>
 * 创建者：zhanggaojie<br/>
 * 修改者：暂无<br/>
 * 修改简述：暂无<br/>
 * 修改详述：
 * <p>
 * 暂无<br/>
 * </p>
 * 修改时间：暂无<br/>
 */
package com.zhang.core.shiro.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.realm.Realm;
import org.springframework.stereotype.Component;

import com.zhang.module.bean.UserVo;
import com.zhang.module.login.LoginService;

@Component
public class DataBaseRealm implements Realm {

	private final static String name = DataBaseRealm.class.getName() + "_realmName";

	private LoginService loginService = new LoginService();

	@Override
	public String getName() {
		return name;
	}

	/**
	 * support UsernamePasswordToken
	 */
	@Override
	public boolean supports(AuthenticationToken token) {
		return token instanceof UsernamePasswordToken;
	}

	@Override
	public AuthenticationInfo getAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		String username = (String) token.getPrincipal(); // 得到用户名
		String password = new String((char[]) token.getCredentials()); // 得到密码
		UserVo vo = loginService.getUser(username);
		System.out.println(vo);
		if(vo==null){
			throw new UnknownAccountException(); // 如果用户名错误
		}
		// 如果身份认证验证成功，返回一个AuthenticationInfo实现；
		return new SimpleAuthenticationInfo(username, password, getName());
	}
}