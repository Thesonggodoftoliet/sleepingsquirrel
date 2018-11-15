/**
 * 
 */
package com.sleepingsquirrel.dao.impl;

import com.sleepingsquirrel.dao.UserDao;
import com.sleepingsquirrel.instance.User;
import com.sleepingsquirrel.utils.JdbcUtils;

/**
 * @author 李煜峰
 *
 * date:2018年8月19日 time:下午4:50:27
 */
public class UserDaoImpl implements UserDao {

	/**
	 * 
	 */
	public UserDaoImpl() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see com.sleepingsquirrel.dao.UserDao#addUser(com.sleepingsquirrel.instance.User)
	 */
	@Override
	public User addUser(User tuser) {
		// TODO Auto-generated method stub
		String sql="insert into user values(?,?,?,?)";
		int tag = JdbcUtils.executeSQL(sql, tuser.getUserid(),tuser.getUserphone(),tuser.getUseremail(),tuser.getUserpwd());
		if(tag == 0) return null;
		else return tuser;
	}

	/* (non-Javadoc)
	 * @see com.sleepingsquirrel.dao.UserDao#getNumofuser()
	 */
	@Override
	public int getNumofuser() {
		// TODO Auto-generated method stub
		String sql = "select * from user";
		return JdbcUtils.getListCount(sql);
	}

	/* (non-Javadoc)
	 * @see com.sleepingsquirrel.dao.UserDao#getUserbyphone(com.sleepingsquirrel.instance.User)
	 */
	@Override
	public User getUserbyphone(User tuser) {
		// TODO Auto-generated method stub
		String sql = "select * from user where userphone=?";
		return (User)JdbcUtils.getObjectById(User.class, sql, tuser.getUserphone());
	}

	/* (non-Javadoc)
	 * @see com.sleepingsquirrel.dao.UserDao#getUserbyemail(com.sleepingsquirrel.instance.User)
	 */
	@Override
	public User getUserbyemail(User tuser) {
		// TODO Auto-generated method stub
		String sql = "select * from user where useremail=?";
		return (User)JdbcUtils.getObjectById(User.class, sql, tuser.getUseremail());
	}

	/* (non-Javadoc)
	 * @see com.sleepingsquirrel.dao.UserDao#deleteUserbyphone(com.sleepingsquirrel.instance.User)
	 */
	@Override
	public boolean deleteUserbyphone(User tuser) {
		// TODO Auto-generated method stub
		int tag = 0;
		String sql = "delete from user where userphone = ?";
		tag = JdbcUtils.executeSQL(sql, tuser.getUserphone());
		if (tag == 1)return true;
		return false;
	}

	/* (non-Javadoc)
	 * @see com.sleepingsquirrel.dao.UserDao#deleteUserbyemail(com.sleepingsquirrel.instance.User)
	 */
	@Override
	public boolean deleteUserbyemail(User tuser) {
		// TODO Auto-generated method stub
		int tag = 0;
		String sql = "delete from user where useremail= ?";
		tag = JdbcUtils.executeSQL(sql, tuser.getUseremail());
		if(tag == 1) return true;
		return false;
	}

	/* (non-Javadoc)
	 * @see com.sleepingsquirrel.dao.UserDao#updateUserbyphone(com.sleepingsquirrel.instance.User)
	 */
	@Override
	public boolean updateUserbyphone(User tuser) {
		// TODO Auto-generated method stub
		String sql ="update user set userpwd = ?,useremail=? where userphone=?";
		int tag = JdbcUtils.executeSQL(sql, tuser.getUserpwd(),tuser.getUseremail(),tuser.getUserphone());
		if (tag == 0) return false;
		else return true;
	}

	/* (non-Javadoc)
	 * @see com.sleepingsquirrel.dao.UserDao#updateUserbyemail(com.sleepingsquirrel.instance.User)
	 */
	@Override
	public boolean updateUserbyemail(User tuser) {
		// TODO Auto-generated method stub
		String sql ="update user set userpwd = ?,userphone=? where useremail=?";
		int tag = JdbcUtils.executeSQL(sql, tuser.getUserpwd(),tuser.getUserphone(),tuser.getUseremail());
		if (tag == 0) return false;
		else return true;
	}

}
