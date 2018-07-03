package com.chorechart.model;

import java.sql.Date;

public class Register {

	String FirstName; 
	String LastName;  
	String Email_username;  
	String Password;  
	Date DateOfBirth; 
	String Relations; 
	boolean Newsletter;  
	Date DateCreated;
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
	public String getEmail_username() {
		return Email_username;
	}
	public void setEmail_username(String email_username) {
		Email_username = email_username;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public Date getDateOfBirth() {
		return DateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		DateOfBirth = dateOfBirth;
	}
	public String getRelations() {
		return Relations;
	}
	public void setRelations(String relations) {
		Relations = relations;
	}
	public boolean isNewsletter() {
		return Newsletter;
	}
	public void setNewsletter(boolean newsletter) {
		Newsletter = newsletter;
	}
	public Date getDateCreated() {
		return DateCreated;
	}
	public void setDateCreated(Date dateCreated) {
		DateCreated = dateCreated;
	}
	@Override
	public String toString() {
		return String.format(
				"Register [FirstName=%s, LastName=%s, Email_username=%s, Password=%s, DateOfBirth=%s, Relations=%s, Newsletter=%s, DateCreated=%s]",
				FirstName, LastName, Email_username, Password, DateOfBirth, Relations, Newsletter, DateCreated);
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Email_username == null) ? 0 : Email_username.hashCode());
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
		Register other = (Register) obj;
		if (Email_username == null) {
			if (other.Email_username != null)
				return false;
		} else if (!Email_username.equals(other.Email_username))
			return false;
		return true;
	} 
	
	

}
