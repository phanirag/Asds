package com.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Vendor {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int vId;
	private String vName;
	private String vAddr;
	public Vendor(int vId, String vName, String vAddr) {
		this.vId = vId;
		this.vName = vName;
		this.vAddr = vAddr;
	}
	public Vendor() {
		super();
	}
	public Vendor(int vId) {
		this.vId = vId;
	}
	public int getvId() {
		return vId;
	}
	public void setvId(int vId) {
		this.vId = vId;
	}
	public String getvName() {
		return vName;
	}
	public void setvName(String vName) {
		this.vName = vName;
	}
	public String getvAddr() {
		return vAddr;
	}
	public void setvAddr(String vAddr) {
		this.vAddr = vAddr;
	}
	@Override
	public String toString() {
		return "Vendor [vId=" + vId + ", vName=" + vName + ", vAddr=" + vAddr
				+ "]";
	}
	
	
	
	
}
