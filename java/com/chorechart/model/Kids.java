package com.chorechart.model;

import java.sql.Date;

public class Kids {
	
	String FirstName;
	String LastName;
	String LoginId;
	String ParentEmail;
	Date LastLogin;
	Date DateOfBirth;
	String Password;
	String KidsEmail;
	Chores choreAssigned;
	
	public Chores getChoreAssigned() {
		return choreAssigned;
	}
	public void setChoreAssigned(Chores choreAssigned) {
		this.choreAssigned = choreAssigned;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return Password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		Password = password;
	}
	/**
	 * @return the kidsEmail
	 */
	public String getKidsEmail() {
		return KidsEmail;
	}
	/**
	 * @param kidsEmail the kidsEmail to set
	 */
	public void setKidsEmail(String kidsEmail) {
		KidsEmail = kidsEmail;
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
	public String getLoginId() {
		return LoginId;
	}
	public void setLoginId(String loginId) {
		LoginId = loginId;
	}
	public String getParentEmail() {
		return ParentEmail;
	}
	public void setParentEmail(String parentEmail) {
		ParentEmail = parentEmail;
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
		result = prime * result + ((LoginId == null) ? 0 : LoginId.hashCode());
		result = prime * result + ((ParentEmail == null) ? 0 : ParentEmail.hashCode());
		
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
		if (!(obj instanceof Kids)) {
			return false;
		}
		Kids other = (Kids) obj;
		if (DateOfBirth == null) {
			if (other.DateOfBirth != null) {
				return false;
			}
		} else if (!DateOfBirth.equals(other.DateOfBirth)) {
			return false;
		}
		if (FirstName == null) {
			if (other.FirstName != null) {
				return false;
			}
		} else if (!FirstName.equals(other.FirstName)) {
			return false;
		}
		if (KidsEmail == null) {
			if (other.KidsEmail != null) {
				return false;
			}
		} else if (!KidsEmail.equals(other.KidsEmail)) {
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
		if (LoginId == null) {
			if (other.LoginId != null) {
				return false;
			}
		} else if (!LoginId.equals(other.LoginId)) {
			return false;
		}
		if (ParentEmail == null) {
			if (other.ParentEmail != null) {
				return false;
			}
		} else if (!ParentEmail.equals(other.ParentEmail)) {
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
		return "Kids [" + (FirstName != null ? "FirstName=" + FirstName + ", " : "")
				+ (LastName != null ? "LastName=" + LastName + ", " : "")
				+ (LoginId != null ? "LoginId=" + LoginId + ", " : "")
				+ (ParentEmail != null ? "ParentEmail=" + ParentEmail + ", " : "")
				+ (LastLogin != null ? "LastLogin=" + LastLogin + ", " : "")
				+ (DateOfBirth != null ? "DateOfBirth=" + DateOfBirth + ", " : "")
				+ (Password != null ? "Password=" + Password + ", " : "")
				+ (KidsEmail != null ? "KidsEmail=" + KidsEmail : "") + "]";
	}
	
	
	
}
