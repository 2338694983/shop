package com.hr.entity;

import java.io.Serializable;

//用户
public class EASYBUY_USER implements Serializable {
	private String EU_USER_ID;//用户账号
	private String EU_USER_NAME;//用户名称
	private String EU_PASSWORD;//用户密码
	private String EU_SEX;//用户性别
	private String EU_BIRTHDAY;//用户出生年与日
	private String EU_IDENTITY_CODE;//身份证号
	private String EU_EMAIL;//用户邮箱
	private String EU_MOBILE;//用户电话号
	private String EU_ADDRESS;//用户地址
	private int EU_STATUS;//是否管理员
	public EASYBUY_USER(){};
	public EASYBUY_USER(String eUUSERID, String eUUSERNAME, String eUPASSWORD,
			String eUSEX, String eUBIRTHDAY, String eUIDENTITYCODE,
			String eUEMAIL, String eUMOBILE, String eUADDRESS, int eUSTATUS) {
		//super();
		EU_USER_ID = eUUSERID;
		EU_USER_NAME = eUUSERNAME;
		EU_PASSWORD = eUPASSWORD;
		EU_SEX = eUSEX;
		EU_BIRTHDAY = eUBIRTHDAY;
		EU_IDENTITY_CODE = eUIDENTITYCODE;
		EU_EMAIL = eUEMAIL;
		EU_MOBILE = eUMOBILE;
		EU_ADDRESS = eUADDRESS;
		EU_STATUS = eUSTATUS;
	}

	
	public String getEU_USER_ID() {
		return EU_USER_ID;
	}
	public void setEU_USER_ID(String eUUSERID) {
		EU_USER_ID = eUUSERID;
	}
	public String getEU_USER_NAME() {
		return EU_USER_NAME;
	}
	public void setEU_USER_NAME(String eUUSERNAME) {
		EU_USER_NAME = eUUSERNAME;
	}
	public String getEU_PASSWORD() {
		return EU_PASSWORD;
	}
	public void setEU_PASSWORD(String eUPASSWORD) {
		EU_PASSWORD = eUPASSWORD;
	}
	public String getEU_SEX() {
		return EU_SEX;
	}
	public void setEU_SEX(String eUSEX) {
		EU_SEX = eUSEX;
	}
	public String getEU_BIRTHDAY() {
		return EU_BIRTHDAY;
	}
	public void setEU_BIRTHDAY(String eUBIRTHDAY) {
		EU_BIRTHDAY = eUBIRTHDAY;
	}
	public String getEU_IDENTITY_CODE() {
		return EU_IDENTITY_CODE;
	}
	public void setEU_IDENTITY_CODE(String eUIDENTITYCODE) {
		EU_IDENTITY_CODE = eUIDENTITYCODE;
	}
	public String getEU_EMAIL() {
		return EU_EMAIL;
	}
	public void setEU_EMAIL(String eUEMAIL) {
		EU_EMAIL = eUEMAIL;
	}
	public String getEU_MOBILE() {
		return EU_MOBILE;
	}
	public void setEU_MOBILE(String eUMOBILE) {
		EU_MOBILE = eUMOBILE;
	}
	public String getEU_ADDRESS() {
		return EU_ADDRESS;
	}
	public void setEU_ADDRESS(String eUADDRESS) {
		EU_ADDRESS = eUADDRESS;
	}
	public int getEU_STATUS() {
		return EU_STATUS;
	}
	public void setEU_STATUS(int eUSTATUS) {
		EU_STATUS = eUSTATUS;
	}
	
}
