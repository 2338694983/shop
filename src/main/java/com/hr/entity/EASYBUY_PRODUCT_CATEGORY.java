package com.hr.entity;

import java.io.Serializable;

//商品分类
public class EASYBUY_PRODUCT_CATEGORY implements Serializable {
	private int EPC_ID;//物品类型
	private String EPC_NAME;//物品类型名称
	private int EPC_PARENT_ID;//
	public EASYBUY_PRODUCT_CATEGORY(int ePCID, String ePCNAME, int ePCPARENTID) {
		//super();
		EPC_ID = ePCID;
		EPC_NAME = ePCNAME;
		EPC_PARENT_ID = ePCPARENTID;
	}
	public EASYBUY_PRODUCT_CATEGORY(){};
	public int getEPC_ID() {
		return EPC_ID;
	}
	public void setEPC_ID(int ePCID) {
		EPC_ID = ePCID;
	}
	public String getEPC_NAME() {
		return EPC_NAME;
	}
	public void setEPC_NAME(String ePCNAME) {
		EPC_NAME = ePCNAME;
	}
	public int getEPC_PARENT_ID() {
		return EPC_PARENT_ID;
	}
	public void setEPC_PARENT_ID(int ePCPARENTID) {
		EPC_PARENT_ID = ePCPARENTID;
	}
}
