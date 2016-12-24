package com.satya.core.bean;

public class Department {
	
private String depName;
private String status;


public Department(){}


public Department(String depName, String status) {
	super();
	this.depName = depName;
	this.status = status;
}
public String getDepName() {
	return depName;
}
public void setDepName(String depName) {
	this.depName = depName;
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
	result = prime * result + ((depName == null) ? 0 : depName.hashCode());
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
	Department other = (Department) obj;
	if (depName == null) {
		if (other.depName != null)
			return false;
	} else if (!depName.equals(other.depName))
		return false;
	return true;
}




}
