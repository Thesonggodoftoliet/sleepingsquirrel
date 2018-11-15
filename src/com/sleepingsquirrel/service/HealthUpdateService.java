/**
 * 
 */
package com.sleepingsquirrel.service;

import java.sql.Date;

import com.sleepingsquirrel.instance.Health;

/**
 * @author 李煜峰
 *
 * date:2018年10月18日 time:上午8:30:45
 */
public interface HealthUpdateService {
	String getTime();
	
	String updateInfo(Health health);
}
