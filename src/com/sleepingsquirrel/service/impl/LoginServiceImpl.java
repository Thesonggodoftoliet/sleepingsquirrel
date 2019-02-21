/**
 * 
 */
package com.sleepingsquirrel.service.impl;

import com.sleepingsquirrel.dao.UserDao;
import com.sleepingsquirrel.dao.impl.UserDaoImpl;
import com.sleepingsquirrel.instance.User;
import com.sleepingsquirrel.service.LoginService;

/**
 * @author 李煜峰
 *
 * date:2018年8月21日 time:下午9:27:38
 */
public class LoginServiceImpl implements LoginService {

	/**
	 * 
	 */
	public LoginServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see com.sleepingsquirrel.service.LoginService#getUser(com.sleepingsquirrel.instance.User)
	 */
	@Override
	public User getUser(User tuser) {
		// TODO Auto-generated method stub
		UserDao userdao = new UserDaoImpl();
		if(tuser.getUseremail() == null) return userdao.getUserbyphone(tuser);
		return userdao.getUserbyemail(tuser);
	}


	/* (non-Javadoc)
	 * @see com.sleepingsquirrel.service.LoginService#loginCheck(com.sleepingsquirrel.instance.User)
	 */
	@Override
	public String loginCheck(User tuser) {
		// TODO Auto-generated method stub
		// 0 登陆成功 1密码错误 2账号无效
		User sqluser = null;
		sqluser = this.getUser(tuser);
		
		if (sqluser == null) return "2";
		else{
			if(sqluser.getUserpwd().equals(tuser.getUserpwd())) return Integer.toString(sqluser.getUserid());
			
			else return "0";
		}

	}

}
