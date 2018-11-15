/**
 * 
 */
package com.sleepingsquirrel.dao;

import com.sleepingsquirrel.instance.User;

/**
 * @author 李煜峰
 *
 * date:2018年8月19日 time:下午4:05:24
 */
public interface UserDao {
	
	User getUserbyphone(User tuser);
	
	User getUserbyemail(User tuser);
	
	User addUser(User tuser);
	
	int getNumofuser();
	
	boolean updateUserbyphone(User tuser);
	
	boolean updateUserbyemail(User tuser);

	boolean deleteUserbyphone(User tuser);
	
	boolean deleteUserbyemail(User tuser);
}
