package com.chorechart.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Errors;

import com.chorechart.model.Parents;
import com.chorechart.model.Register;
@Component
public class FormValidator implements Validator {

	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return Register.class.isAssignableFrom(arg0);
	}	

	@Override
	public void validate(Object arg0, Errors arg1) {
		
		ValidationUtils.rejectIfEmptyOrWhitespace( arg1,"FirstName", "arg1.firstName","First Name is required!!!!!!");
		ValidationUtils.rejectIfEmptyOrWhitespace( arg1,"LastName", "arg1.lastName","Last Name is required@@@@@");
		ValidationUtils.rejectIfEmptyOrWhitespace( arg1,"Email_username", "arg1.email_username","Email USer Name is required");
		//ValidationUtils.rejectIfEmptyOrWhitespace( arg1,"dateOfBirth", "arg1.DateOfBirth","Date of Birth is required");
		//ValidationUtils.rejectIfEmptyOrWhitespace( arg1,"dateOfBirth", "field.required","Date of Birth is required");
		// TODO Auto-generated method stub
				if(arg1.getFieldValue("dateOfBirth").toString().equals("")) {
					arg1.rejectValue(arg1.getFieldValue("dateOfBirth").toString(),"Date Of birth Cannot be blank");
				}
		ValidationUtils.rejectIfEmptyOrWhitespace( arg1,"Password", "arg1.Password","Password is required");
		if (arg1.getFieldValue("relations").toString().equals("-")){
			ValidationUtils.rejectIfEmptyOrWhitespace( arg1,"relations", "arg1.Relations","Relations is required");
		}
		
	}

}
