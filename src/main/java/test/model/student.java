package test.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
//@Table(name="student_data") Used to set database table name without this class name is used for creating table
public class student {
	
	@Id //@Id is used to set the primary key / unique key
	@GeneratedValue(strategy = GenerationType.AUTO) // It is used to set column auto-increment 
	private int id;
	
	//@Column(name="first_name") //Using this we can set column name in database table without this by default it uses the string variable for ex. fname
	@Column //Some time columns are not generated automatically so we use @Column to generate the columns
	private String fname;
	
	@Column
	private String lname;
	
	@Column
	private String email;
	
	@Column
	private String password;
	
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
