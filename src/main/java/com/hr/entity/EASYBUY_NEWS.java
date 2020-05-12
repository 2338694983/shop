package com.hr.entity;

import java.io.Serializable;

//新闻
public class EASYBUY_NEWS implements Serializable {
	private int EN_ID;
	private String EN_TITLE;//新闻动态链接名
	private String EN_CONTENT;
	private String EN_CREATE_TIME;//创建时间

	public EASYBUY_NEWS(){};
	public EASYBUY_NEWS(int eNID, String eNTITLE, String eNCONTENT,
			String eNCREATETIME) {
		//super();
		EN_ID = eNID;
		EN_TITLE = eNTITLE;
		EN_CONTENT = eNCONTENT;
		EN_CREATE_TIME = eNCREATETIME;
	}
	public int getEN_ID() {
		return EN_ID;
	}
	public void setEN_ID(int eNID) {
		EN_ID = eNID;
	}
	public String getEN_TITLE() {
		return EN_TITLE;
	}
	public void setEN_TITLE(String eNTITLE) {
		EN_TITLE = eNTITLE;
	}
	public String getEN_CONTENT() {
		return EN_CONTENT;
	}
	public void setEN_CONTENT(String eNCONTENT) {
		EN_CONTENT = eNCONTENT;
	}
	public String getEN_CREATE_TIME() {
		return EN_CREATE_TIME;
	}
	public void setEN_CREATE_TIME(String eNCREATETIME) {
		EN_CREATE_TIME = eNCREATETIME;
	}
}
