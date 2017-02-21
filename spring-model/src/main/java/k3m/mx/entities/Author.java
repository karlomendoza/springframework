package k3m.mx.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="author")
public class Author {
	@Id
	@Column(name="idAuthor")
	private Integer idAuthor;
	
	@Column(name="firstName")
	private String firstName;
	
	@Column(name="lastName")
	private String lastName;
	
	public Author(){
		
	}
	
	public Author(Integer idAuthor, String firstName, String lastName){
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

	public Integer getIdAuthor() {
		return idAuthor;
	}

	public void setIdAuthor(Integer idAuthor) {
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
