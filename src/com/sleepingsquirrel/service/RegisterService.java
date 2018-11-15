/**
 * 
 */
package com.sleepingsquirrel.service;

import com.sleepingsquirrel.instance.User;

/**
 * @author 赵晧辰
 *
 * date:2018年8月20日 time:下午2:09:13
 */
public interface RegisterService{
	
	int getMaxrows();

	User getUser(User tempUser);
	
	String addUser(User tempUser);
}
