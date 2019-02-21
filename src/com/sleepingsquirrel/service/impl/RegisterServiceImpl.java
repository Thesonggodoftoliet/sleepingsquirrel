/**
 * 
 */
package com.sleepingsquirrel.service.impl;

import com.sleepingsquirrel.instance.User;
import com.sleepingsquirrel.service.RegisterService;
import com.sleepingsquirrel.dao.UserDao;
import com.sleepingsquirrel.dao.impl.*;

/**
 * @author 赵晧辰
 *
 * date:2018年8月20日 time:下午2:16:36
 */
public class RegisterServiceImpl implements RegisterService {
	
	/* (non-Javadoc)
	 * @see com.sleepingsquirrel.service.RegisterService#getUser(com.sleepingsquirrel.instance.User)
	 */
	@Override
	public User getUser(User tempUser) {
		
		UserDaoImpl UDI = new UserDaoImpl();
		
		if(tempUser.getUserphone() != null) {
			return UDI.getUserbyphone(tempUser);
		}
		else if(tempUser.getUseremail() != null) {
			return UDI.getUserbyemail(tempUser);
		}
		else {
			return null;
		}
	}

	/* (non-Javadoc)
	 * @see com.sleepingsquirrel.service.RegisterService#addUser(com.sleepingsquirrel.instance.User)
	 */
	@Override
	public String addUser(User tempUser) {
		
		UserDaoImpl UDI = new UserDaoImpl();
		tempUser.setUserid(getMaxrows()+1);
		
		if(getUser(tempUser)==null) {
			UDI.addUser(tempUser);
			return Integer.toString(tempUser.getUserid());
		}
		else {
			return "0";
		}
	}

	/* (non-Javadoc)
	 * @see com.sleepingsquirrel.service.RegisterService#getMaxrows()
	 */
	@Override
	public int getMaxrows() {
		// TODO Auto-generated method stub
		UserDao userdao = new UserDaoImpl();
		return userdao.getNumofuser();
	}

}
