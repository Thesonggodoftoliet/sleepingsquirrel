/**
 * 
 */
package com.sleepingsquirrel.instance;

/**
 * @author 李煜峰
 *
 * date:2018年9月14日 time:上午8:19:41
 */
public class Food {
	
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
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

	private String id;
	private String name;
	private int calorie;

	/**
	 * 
	 */
	public Food() {
		// TODO Auto-generated constructor stub
	}

}
