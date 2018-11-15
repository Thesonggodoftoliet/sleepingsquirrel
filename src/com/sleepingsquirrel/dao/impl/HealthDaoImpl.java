/**
 * 
 */
package com.sleepingsquirrel.dao.impl;

import java.util.List;

import com.sleepingsquirrel.dao.HealthDao;
import com.sleepingsquirrel.instance.Health;
import com.sleepingsquirrel.utils.JdbcUtils;

/**
 * @author 李煜峰
 *
 * date:2018年10月17日 time:下午2:32:41
 */
public class HealthDaoImpl implements HealthDao {

	/**
	 * 
	 */
	public HealthDaoImpl() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see com.sleepingsquirrel.dao.HealthDao#getInfoByuserid(java.lang.String)
	 */
	@Override
	public List<HealthDao> getInfoByuserid(int userid) {
		// TODO Auto-generated method stub
		String sql = "select * from health where userid = "+userid;
		return JdbcUtils.getList(Health.class, sql);
	}

	/* (non-Javadoc)
	 * @see com.sleepingsquirrel.dao.HealthDao#addHealth(com.sleepingsquirrel.dao.HealthDao)
	 */
	@Override
	public boolean addHealth(Health health) {
		// TODO Auto-generated method stub
		int tag = 0;
		String sql = "insert into health values(?,?,?,?)";
		tag = JdbcUtils.executeSQL(sql, health.getUserid(),health.getDate(),health.getCalorie(),health.getNumofstep());
		if ( tag == 1) return true;
		return false;
	}

	/* (non-Javadoc)
	 * @see com.sleepingsquirrel.dao.HealthDao#deleteByid(java.lang.String)
	 */
	@Override
	public boolean deleteByid(int userid) {
		// TODO Auto-generated method stub
		String sql = "delete from health where date in (select top 1 * from health where userid= ? oder by modifytime";
		int tag = JdbcUtils.executeSQL(sql, userid);
		if (tag == 1) return true;
		return false;
	}

	/* (non-Javadoc)
	 * @see com.sleepingsquirrel.dao.HealthDao#deleteallByid(java.lang.String)
	 */
	@Override
	public boolean deleteallByid(int userid) {
		// TODO Auto-generated method stub
		String sql = "delete from health where userid = ?";
		int tag = JdbcUtils.executeSQL(sql, userid);
		if(tag != 0) return true;
		return false;
	}

	/* (non-Javadoc)
	 * @see com.sleepingsquirrel.dao.HealthDao#getNumofInfo(int)
	 */
	@Override
	public int getNumofInfo(int userid) {
		// TODO Auto-generated method stub
		String sql = "select * from health where userid ="+userid;
		return JdbcUtils.getListCount(sql);
	}

}