/**
 * 
 */
package com.sleepingsquirrel.dao;

import java.util.List;

import com.sleepingsquirrel.instance.Health;

/**
 * @author 李煜峰
 *
 * date:2018年10月17日 time:下午2:05:38
 */
public interface HealthDao {
	
	List<Health> getInfoByuserid(int userid);
	
	boolean addHealth(Health health);

	boolean updateHealth(Health health);
	
	boolean deleteByid(int userid);//删除时间最前的一条
	
	boolean deleteallByid(int userid);//删除所有
	
	int getNumofInfo(int userid);
	
	
}
