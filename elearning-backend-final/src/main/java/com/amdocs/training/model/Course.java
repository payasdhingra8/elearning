package com.amdocs.training.model;

public class Course {
	
	private Long cId;
	private String cName;
	private String cDesp;
	private String cFees;
	private String cResources;
	
	public Course(Long cId, String cName, String cDesp, String cFees, String cResources) {
		super();
		this.cId = cId;
		this.cName = cName;
		this.cDesp = cDesp;
		this.cFees = cFees;
		this.cResources = cResources;
	}

	public Long getcId() {
		return cId;
	}

	public void setcId(Long cId) {
		this.cId = cId;
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public String getcDesp() {
		return cDesp;
	}

	public void setcDesp(String cDesp) {
		this.cDesp = cDesp;
	}

	public String getcFees() {
		return cFees;
	}

	public void setcFees(String cFees) {
		this.cFees = cFees;
	}

	public String getcResources() {
		return cResources;
	}

	public void setcResources(String cResources) {
		this.cResources = cResources;
	}

	@Override
	public String toString() {
		return "Course [cId=" + cId + ", cName=" + cName + ", cDesp=" + cDesp + ", cFees=" + cFees + ", cResources="
				+ cResources + "]";
	}
	

	
	
	
	

}
