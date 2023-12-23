package model;

import java.util.ArrayList;

public class User {
  
	private String fname;
	private String lname;
	private String email;
	private String pass;
	private String mobile;
	private String gender;
	private String ngo;
	private String idproof;
	private String role;
	private int id;
	private boolean confirmed;

    public boolean isConfirmed() {
        return confirmed;
    }

    public void setConfirmed(boolean confirmed) {
        this.confirmed = confirmed;
    }
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getNgo() {
		return ngo;
	}
	public void setNgo(String ngo) {
		this.ngo = ngo;
	}
	public String getIdproof() {
		return idproof;
	}
	public void setIdproof(String idproof) {
		this.idproof = idproof;
	}
	
	public User(String fname, String lname, String email, String pass, String mobile, String gender, String ngo,
			String idproof,boolean confirmed) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.pass = pass;
		this.mobile = mobile;
		this.gender = gender;
		this.ngo = ngo;
		this.idproof = idproof;
		this.confirmed = confirmed;
	}
	public User(int id, String ngo, String email, String pass, String mobile, String gender, 
			String idproof,boolean confirmed) {
		super();
		this.id= id;
		this.ngo = ngo;
		this.email = email;
		this.pass = pass;
		this.mobile = mobile;
		this.gender = gender;
		this.idproof = idproof;
		this.confirmed = confirmed;
	}
	public User(int id,String fname, String lname, String email, String pass, String mobile, String gender, String idproof,
			String role,boolean confirmed) {
		super();
		this.id= id;
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.pass = pass;
		this.mobile = mobile;
		this.gender = gender;
		this.role=role;
		this.idproof = idproof;
		 this.confirmed = confirmed;
	}
	public User(int id,String fname, String lname, String email, String pass, String mobile, String gender, String idproof,
			boolean confirmed) {
		super();
		this.id= id;
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.pass = pass;
		this.mobile = mobile;
		this.gender = gender;
		
		this.idproof = idproof;
		 this.confirmed = confirmed;
	}

	public User(String ngo) {
		super();
		this.ngo = ngo;
	}

	public User(int id, String fname, String lname, String email, String pass, String mobile, String gender,
			String idproof, String ngo) {
		super();
		this.id= id;
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.pass = pass;
		this.mobile = mobile;
		this.gender = gender;
		this.idproof = idproof;
		 this.ngo=ngo;
	}
	

}
