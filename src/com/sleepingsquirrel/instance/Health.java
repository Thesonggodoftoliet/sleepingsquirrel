/**
 * 
 */
package com.sleepingsquirrel.instance;

/**
 * @author 李煜峰
 *
 * date:2018年10月9日 time:下午5:24:01
 */
public class Health {

	/**
	 * 
	 */
	public Health() {
		// TODO Auto-generated constructor stub
	}
	
	private int userid;
	private String date;
	private int calorie;
	private int numofstep;
	private String keyword;

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword() {
		this.keyword = Integer.toString(userid)+date;
	}

	public void setKeyword(String keyword) {this.keyword = keyword;}
	
	/**
	 * @return the userid
	 */
	public int getUserid() {
		return userid;
	}
	/**
	 * @param userid the userid to set
	 */
	public void setUserid(int userid) {
		this.userid = userid;
	}
	/**
	 * @return the date
	 */
	public String getDate() {
		return date;
	}
	/**
	 * @param date the date to set
	 */
	public void setDate(String date) {
		this.date = date;
	}
	/**
	 * @return the calorie
	 */
	public int getCalorie() {
		return calorie;
	}
	/**
	 * @param calorie the calorie to set
	 */
	public void setCalorie(int calorie) {
		this.calorie = calorie;
	}
	/**
	 * @return the numofstep
	 */
	public int getNumofstep() {
		return numofstep;
	}
	/**
	 * @param numofstep the numofstep to set
	 */
	public void setNumofstep(int numofstep) {
		this.numofstep = numofstep;
	}

}
