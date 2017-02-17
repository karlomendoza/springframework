package k3m.mx.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="author")
public class Author {
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="idAuthor")
	private int idAuthor;
	
	@Column(name="firstName")
	private String firstName;
	
	@Column(name="lastName")
	private String lastName;
	
	public Author(){
		
	}
	
	public Author(int idAuthor, String firstName, String lastName){
		this.idAuthor = idAuthor;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	@Override
	public String toString(){
		return String.format(
				"[idAuthor=%s, firstName='%s', lastName='%s']",
				idAuthor, firstName, lastName);
	}

	public int getIdAuthor() {
		return idAuthor;
	}

	public void setIdAuthor(int idAuthor) {
		this.idAuthor = idAuthor;
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
	
	
}
