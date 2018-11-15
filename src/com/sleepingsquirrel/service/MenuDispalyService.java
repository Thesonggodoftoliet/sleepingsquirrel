/**
 * 
 */
package com.sleepingsquirrel.service;

import java.util.List;

import com.sleepingsquirrel.instance.Food;

/**
 * @author 李煜峰
 *
 * date:2018年9月14日 time:上午9:22:52
 */
public interface MenuDispalyService {
	List<Food> getMenuList(String foodname);
	
	List<Food> Search(String foodname);
}
