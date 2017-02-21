package k3m.mx.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="students")
public class Student {
	@Id
	@Column(name="idStudent")
	private Integer idStudent;
	
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
	
	public Student(Integer idStudent, String firstName, String lastName, String studentAdress, String phoneNumber,
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
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((emailAdress == null) ? 0 : emailAdress.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((idStudent == null) ? 0 : idStudent.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((phoneNumber == null) ? 0 : phoneNumber.hashCode());
		result = prime * result + ((studentAdress == null) ? 0 : studentAdress.hashCode());
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
		Student other = (Student) obj;
		if (emailAdress == null) {
			if (other.emailAdress != null)
				return false;
		} else if (!emailAdress.equals(other.emailAdress))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (idStudent == null) {
			if (other.idStudent != null)
				return false;
		} else if (!idStudent.equals(other.idStudent))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (phoneNumber == null) {
			if (other.phoneNumber != null)
				return false;
		} else if (!phoneNumber.equals(other.phoneNumber))
			return false;
		if (studentAdress == null) {
			if (other.studentAdress != null)
				return false;
		} else if (!studentAdress.equals(other.studentAdress))
			return false;
		return true;
	}

	public Integer getIdStudent() {
		return idStudent;
	}

	public void setIdStudent(Integer idStudent) {
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
