package k3m.mx.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="students")
public class Student {
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="idStudent")
	private int idStudent;
	
	@Column(name="firstName")
	private String firstName;
	
	@Column(name="lastName")
	private String lastName;
	
	@Column(name="student_adress")
	private String studentAdress;
	
	@Column(name="phone_number")
	private String phoneNumber;
	
	@Column(name="email_adress")
	private String emailAdress;
	
	public Student(){
		
	}

	
	
	public Student(int idStudent, String firstName, String lastName, String studentAdress, String phoneNumber,
			String emailAdress) {
		this.idStudent = idStudent;
		this.firstName = firstName;
		this.lastName = lastName;
		this.studentAdress = studentAdress;
		this.phoneNumber = phoneNumber;
		this.emailAdress = emailAdress;
	}



	@Override
	public String toString() {
		return "Student [idStudent=" + idStudent + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", studentAdress=" + studentAdress + ", phoneNumber=" + phoneNumber + ", emailAdress=" + emailAdress
				+ "]";
	}



	public int getIdStudent() {
		return idStudent;
	}



	public void setIdStudent(int idStudent) {
		this.idStudent = idStudent;
	}



	public String getFirstName() {
		return firstName;
	}



	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}



	public String getLastName() {
		return lastName;
	}



	public void setLastName(String lastName) {
		this.lastName = lastName;
	}



	public String getStudentAdress() {
		return studentAdress;
	}



	public void setStudentAdress(String studentAdress) {
		this.studentAdress = studentAdress;
	}



	public String getPhoneNumber() {
		return phoneNumber;
	}



	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}



	public String getEmailAdress() {
		return emailAdress;
	}



	public void setEmailAdress(String emailAdress) {
		this.emailAdress = emailAdress;
	}



}
