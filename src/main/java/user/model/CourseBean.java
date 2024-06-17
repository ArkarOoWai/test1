package user.model;

import java.io.Serializable;

public class CourseBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private int cId;
	private String cName;
	private double cFees;
	private double cDuration;
	private boolean status;
		
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public int getcId() {
		return cId;
	}
	public void setcId(int cId) {
		this.cId = cId;
	}
	public String getcName() {
		return cName;
	}
	public void setcName(String cName) {
		this.cName = cName;
	}
	public double getcFees() {
		return cFees;
	}
	public void setcFees(double cFees) {
		this.cFees = cFees;
	}
	public double getcDuration() {
		return cDuration;
	}
	public void setcDuration(double cDuration) {
		this.cDuration = cDuration;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
}
