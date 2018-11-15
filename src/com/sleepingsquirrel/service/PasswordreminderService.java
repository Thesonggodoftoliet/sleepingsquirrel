/**
 * 
 */
package com.sleepingsquirrel.service;

import com.sleepingsquirrel.instance.User;

/**
 * @author 李煜峰
 *
 * date:2018年8月23日 time:下午3:43:37
 */
public interface PasswordreminderService {
	User getUser(User tuser);
	
	String editPassword(User tuser);
}
