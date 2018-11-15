/**
 * 
 */
package com.sleepingsquirrel.dao.impl;

import java.util.List;

import com.sleepingsquirrel.dao.FoodDao;
import com.sleepingsquirrel.instance.Food;
import com.sleepingsquirrel.utils.JdbcUtils;

/**
 * @author 李煜峰
 *
 * date:2018年9月14日 time:上午8:29:41
 */
public class FoodDaoImpl implements FoodDao {

	/**
	 * 
	 */
	public FoodDaoImpl() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see com.sleepingsquirrel.dao.FoodDao#getMenu(java.lang.String)
	 */
	@Override
	public List<Food> getMenu(String keyword) {
		// TODO Auto-generated method stub
		String sql ="select * from food where name like '%"+keyword+"%' order by"
				+ "(case when name = '"+keyword+"' then 1 "
				+ "when name like '"+keyword+"%' then 2 "
				+ "when name like '%"+keyword+"' then 3 "
				+ "when name like '%"+keyword+"%' then 4 "
				+ "else 0 end) limit 0,50;";
		System.out.println("数据库语句"+sql);
		return JdbcUtils.getList(Food.class,sql);
	}

	/* (non-Javadoc)
	 * @see com.sleepingsquirrel.dao.FoodDao#addFood(com.sleepingsquirrel.instance.Food)
	 */
	@Override
	public boolean addFood(Food food) {
		// TODO Auto-generated method stub
		String sql ="insert into food values(?,?,?);";
		int tag = JdbcUtils.executeSQL(sql, food.getId(),food.getName(),food.getCalorie());
		if (tag == 1) return true;
		return false;
	}

	/* (non-Javadoc)
	 * @see com.sleepingsquirrel.dao.FoodDao#updateFoodById(com.sleepingsquirrel.instance.Food)
	 */
	@Override
	public boolean updateFoodById(Food food) {
		// TODO Auto-generated method stub
		String sql = "update food set id = ?, name =?,calorie = ? where id = ?;";
		int tag = JdbcUtils.executeSQL(sql, food.getId(),food.getName(),food.getCalorie(),food.getId());
		if(tag == 1) return true;
		return false;
	}

	/* (non-Javadoc)
	 * @see com.sleepingsquirrel.dao.FoodDao#deleteFoodById(com.sleepingsquirrel.instance.Food)
	 */
	@Override
	public boolean deleteFoodById(Food food) {
		// TODO Auto-generated method stub
		String sql ="delete from food where id = ?;";
		int tag = JdbcUtils.executeSQL(sql, food.getId());
		if(tag == 1) return true;
		return false;
	}

}
