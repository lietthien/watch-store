package domain;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class User implements Serializable {

	private static final long serialVersionUID = 1L;
private int userid;
@NotBlank(message = "First Name field could not be null")
private String firstname;
@NotBlank(message = "Last Name field could not be null")
private String lastname;

@Pattern(regexp = "^[0-9]{10}$",message = "Phone Number field must be 10 digits")
private String phonenumber;

@Pattern(regexp = "^(.+)@(\\S+)$", message = "Email field is illegal")
private String email;

@NotBlank(message = "Password field could not be null")
private String password;

@NotBlank(message = "Address field could not be null")
private String address;

private String role;
public User() {
	super();
}


public User(int userid, String firstname, String lastname, String phonenumber, String email, String password,
		String address, String role) {
	super();
	this.userid = userid;
	this.firstname = firstname;
	this.lastname = lastname;
	this.phonenumber = phonenumber;
	this.email = email;
	this.password = password;
	this.address = address;
	this.role = role;
}
public int getUserid() {
	return userid;
}
public void setUserid(int userid) {
	this.userid = userid;
}
public String getFirstname() {
	return firstname;
}
public void setFirstname(String firstname) {
	this.firstname = firstname;
}
public String getLastname() {
	return lastname;
}
public void setLastname(String lastname) {
	this.lastname = lastname;
}
public String getPhonenumber() {
	return phonenumber;
}
public void setPhonenumber(String phonenumber) {
	this.phonenumber = phonenumber;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getRole() {
	return role;
}
public void setRole(String role) {
	this.role = role;
}


@Override
public String toString() {
	return "User [userid=" + userid + ", firstname=" + firstname + ", lastname=" + lastname + ", phonenumber="
			+ phonenumber + ", email=" + email + ", password=" + password + ", address=" + address + ", role=" + role
			+ "]";
}
}
