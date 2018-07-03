package com.chorechart.model;

import java.sql.Date;
import java.util.List;

public class Parents {

	String FirstName; 
	String LastName;  
	String UserName;  
	String Password;  
	Date LastLogin;
	Date DateOfBirth;
	List<Kids> kids;
	/**
	 * @return the kids
	 */
	public List<Kids> getKids() {
		return kids;
	}
	/**
	 * @param kids the kids to set
	 */
	public void setKids(List<Kids> kids) {
		this.kids = kids;
	}
	/**
	 * @return the dateOfBirth
	 */
	public Date getDateOfBirth() {
		return DateOfBirth;
	}
	/**
	 * @param dateOfBirth the dateOfBirth to set
	 */
	public void setDateOfBirth(Date dateOfBirth) {
		DateOfBirth = dateOfBirth;
	}
	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	
	/**
	 * @return the userName
	 */
	public String getUserName() {
		return UserName;
	}
	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		UserName = userName;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public Date getLastLogin() {
		return LastLogin;
	}
	public void setLastLogin(Date lastLogin) {
		LastLogin = lastLogin;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((UserName == null) ? 0 : UserName.hashCode());
		return result;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Parents)) {
			return false;
		}
		Parents other = (Parents) obj;
		if (DateOfBirth == null) {
			if (other.DateOfBirth != null) {
				return false;
			}
		} else if (!DateOfBirth.equals(other.DateOfBirth)) {
			return false;
		}
		if (UserName== null) {
			if (other.UserName!= null) {
				return false;
			}
		} else if (!UserName.equals(other.UserName)) {
			return false;
		}
		if (FirstName == null) {
			if (other.FirstName != null) {
				return false;
			}
		} else if (!FirstName.equals(other.FirstName)) {
			return false;
		}
		if (LastLogin == null) {
			if (other.LastLogin != null) {
				return false;
			}
		} else if (!LastLogin.equals(other.LastLogin)) {
			return false;
		}
		if (LastName == null) {
			if (other.LastName != null) {
				return false;
			}
		} else if (!LastName.equals(other.LastName)) {
			return false;
		}
		if (Password == null) {
			if (other.Password != null) {
				return false;
			}
		} else if (!Password.equals(other.Password)) {
			return false;
		}
		return true;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Parents [" + (FirstName != null ? "FirstName=" + FirstName + ", " : "")
				+ (LastName != null ? "LastName=" + LastName + ", " : "")
				+ (UserName!= null ? "Email_username=" + UserName+ ", " : "")
				+ (Password != null ? "Password=" + Password + ", " : "")
				+ (LastLogin != null ? "LastLogin=" + LastLogin + ", " : "")
				+ (DateOfBirth != null ? "DateOfBirth=" + DateOfBirth : "") + "]";
	}
	
	

}
