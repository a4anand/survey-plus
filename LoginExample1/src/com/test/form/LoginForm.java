package com.test.form;

/*import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotEmpty;*/

public class LoginForm {
	/*@NotEmpty
	@Size(min = 1, max = 50)*/
	private String userName;
	/*@NotEmpty
	@Size(min = 1, max = 20)*/
	private String password;
	private String survey_type;

	

	public String getSurvey_type() {
		return survey_type;
	}

	public void setSurvey_type(String survey_type) {
		this.survey_type = survey_type;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserName() {
		return userName;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

}