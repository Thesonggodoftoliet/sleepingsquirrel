/**
 * 
 */
package com.sleepingsquirrel.service;

import com.sleepingsquirrel.instance.User;

/**
 * @author 李煜峰
 *
 * date:2018年8月19日 time:下午8:34:30
 */
public interface LoginService {
	User getUser(User tuser);

	String loginCheck(User tuser);
}
