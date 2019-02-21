/**
 * 
 */
package com.sleepingsquirrel.service.impl;

import com.sleepingsquirrel.dao.UserDao;
import com.sleepingsquirrel.dao.impl.UserDaoImpl;
import com.sleepingsquirrel.instance.User;
import com.sleepingsquirrel.service.PasswordreminderService;

/**
 * @author 李煜峰
 *
 * date:2018年8月23日 time:下午3:47:45
 */
public class PasswordremindeServiceImpl implements PasswordreminderService {

	/**
	 * 
	 */
	public PasswordremindeServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see com.sleepingsquirrel.service.PasswordreminderService#getUser(com.sleepingsquirrel.instance.User)
	 */
	@Override
	public User getUser(User tuser) {
		// TODO Auto-generated method stub
		UserDao userdao = new UserDaoImpl();
		if(tuser.getUseremail() == null){
			return userdao.getUserbyphone(tuser);
		}
		else if(tuser.getUserphone() == null){
			return userdao.getUserbyemail(tuser);
		}
		else return null;
	}

	/* (non-Javadoc)
	 * @see com.sleepingsquirrel.service.PasswordreminderService#editPassword()
	 */
	@Override
	public String editPassword(User tuser) {
		// TODO Auto-generated method stub
		// 2 无此账号  0 修改失败 ID修改成功
		User sqluser = getUser(tuser);//tuser 存放了用户的电话或邮箱和修改后的密码 
		UserDao userdao = new UserDaoImpl();
		boolean tag = false;
		if(sqluser == null) {
			return "0";
		}
		else {
			sqluser.setUserpwd(tuser.getUserpwd());
			if (sqluser.getUseremail() == null){
				tag=userdao.updateUserbyphone(sqluser);
			}
			else {
				tag=userdao.updateUserbyemail(sqluser);
			}
		}
		if (tag) return Integer.toString(sqluser.getUserid());
		return "0";
	}

}
