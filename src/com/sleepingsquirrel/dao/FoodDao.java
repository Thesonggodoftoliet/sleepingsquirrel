/**
 * 
 */
package com.sleepingsquirrel.dao;

import java.util.List;

import com.sleepingsquirrel.instance.Food;

/**
 * @author 李煜峰
 *
 * date:2018年9月13日 time:下午4:02:21
 */
public interface FoodDao {
	List<Food> getMenu(String keyword);//关键词模糊搜索
	
	boolean addFood(Food food);
	
	boolean updateFoodById(Food food);
	
	boolean deleteFoodById(Food food);
}
