/**
 * 
 */
package com.sleepingsquirrel.service.impl;

import java.sql.Date;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.sleepingsquirrel.dao.HealthDao;
import com.sleepingsquirrel.dao.impl.HealthDaoImpl;
import com.sleepingsquirrel.instance.Health;
import com.sleepingsquirrel.service.HealthUpdateService;

/**
 * @author 李煜峰
 *
 * date:2018年10月18日 time:上午9:01:19
 */
public class HealthUpdateServiceImpl implements HealthUpdateService {

	/**
	 * 
	 */
	public HealthUpdateServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see com.sleepingsquirrel.service.HealthUpdateService#getTime()
	 */
	@Override
	public String getTime() {
		// TODO Auto-generated method stub
		Format FM = new SimpleDateFormat("yyyy-MM-dd");
		Calendar date = Calendar.getInstance();
		date.add(Calendar.DAY_OF_MONTH, -1);
		return FM.format(date);
	}

	/* (non-Javadoc)
	 * @see com.sleepingsquirrel.service.HealthUpdateService#updateInfo(com.sleepingsquirrel.instance.Health)
	 */
	@Override
	public String updateInfo(Health health) {
		// TODO Auto-generated method stub
		//0 上传失败  1 上传成功
		health.setDate(getTime());
		HealthDao HD = new HealthDaoImpl();
		int num = HD.getNumofInfo(health.getUserid());
		if(num == 30){
			if(! HD.deleteByid(health.getUserid())) return "0";
		}
		
		if(HD.addHealth(health)) return "1";
		return "0";
	}

}
