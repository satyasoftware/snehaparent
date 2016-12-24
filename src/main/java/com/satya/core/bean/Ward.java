package com.satya.core.bean;

public class Ward {
	private String wardName;
	private String status;
	
	
	public Ward(){}
	
	public Ward(String wardName, String status) {
		super();
		this.wardName = wardName;
		this.status = status;
	}
	public String getWardName() {
		return wardName;
	}
	public void setWardName(String wardName) {
		this.wardName = wardName;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((wardName == null) ? 0 : wardName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ward other = (Ward) obj;
		if (wardName == null) {
			if (other.wardName != null)
				return false;
		} else if (!wardName.equals(other.wardName))
			return false;
		return true;
	}
	
	
}
