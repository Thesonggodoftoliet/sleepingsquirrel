/**
 * 
 */
package com.sleepingsquirrel.service.impl;

import java.util.List;

import com.huaban.analysis.jieba.JiebaSegmenter;
import com.sleepingsquirrel.dao.FoodDao;
import com.sleepingsquirrel.dao.impl.FoodDaoImpl;
import com.sleepingsquirrel.instance.Food;
import com.sleepingsquirrel.service.MenuDispalyService;

/**
 * @author 李煜峰
 *
 * date:2018年9月14日 time:上午9:26:09
 */
public class MenuDisplayServiceImpl implements MenuDispalyService {

	/**
	 * 
	 */
	public MenuDisplayServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see com.sleepingsquirrel.service.MenuDispalyService#getMenuList(java.lang.String)
	 */
	@Override
	public List<Food> getMenuList(String foodname) {
		// TODO Auto-generated method stub
		FoodDao fd = new FoodDaoImpl();
		return fd.getMenu(foodname);
	}

	/* (non-Javadoc)
	 * @see com.sleepingsquirrel.service.MenuDispalyService#Search(java.lang.String)
	 */
	@Override
	public List<Food> Search(String foodname) {
		// TODO Auto-generated method stub
		int i = 0;
		List<String> temp;
	    JiebaSegmenter segmenter = new JiebaSegmenter();
	    temp = segmenter.sentenceProcess(foodname);
	    if(getMenuList(foodname).isEmpty()){
	    	while(getMenuList(temp.get(i)).isEmpty()){
	    		i++;
	    	}
	    	System.out.println("分词大小"+temp.size()+" i="+i);
	    	if (i>=temp.size()) return null;
	    	return getMenuList(temp.get(i));
	    }
	    else{
	    	return getMenuList(foodname);
	    }
	}

}
