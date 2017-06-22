package model;

import java.io.Serializable;

public class UserBean implements Serializable{
	private int s_id;
	private String s_name;
	private String pass;
	private int c_id;
	/**
	 * s_idを取得します。
	 * @return s_id
	 */
	public int getS_id() {
	    return s_id;
	}
	/**
	 * s_idを設定します。
	 * @param s_id s_id
	 */
	public void setS_id(int s_id) {
	    this.s_id = s_id;
	}
	/**
	 * s_nameを取得します。
	 * @return s_name
	 */
	public String getS_name() {
	    return s_name;
	}
	/**
	 * s_nameを設定します。
	 * @param s_name s_name
	 */
	public void setS_name(String s_name) {
	    this.s_name = s_name;
	}
	/**
	 * passを取得します。
	 * @return pass
	 */
	public String getPass() {
	    return pass;
	}
	/**
	 * passを設定します。
	 * @param pass pass
	 */
	public void setPass(String pass) {
	    this.pass = pass;
	}
	/**
	 * c_idを取得します。
	 * @return c_id
	 */
	public int getC_id() {
	    return c_id;
	}
	/**
	 * c_idを設定します。
	 * @param c_id c_id
	 */
	public void setC_id(int c_id) {
	    this.c_id = c_id;
	}

}
