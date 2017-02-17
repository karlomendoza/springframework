package k3m.mx.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="books")
public class Book {
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="isbn")
	private String isbn;
	
	@Column(name="title")
	private String title;
	
	@Column(name="date_of_publication")
	private Date dateOfPublication;
	
	public Book(){
		
	}
	
	public Book(String isbn, String title, Date dateOfPublication){
		this.isbn = isbn;
		this.title = title;
		this.dateOfPublication = dateOfPublication;
	}
	
	@Override
	public String toString(){
		return String.format(
				"isbn[id=%s, title='%s', dateOfPublication='%s']",
				isbn, title, dateOfPublication);
	}
	
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getDateOfPublication() {
		return dateOfPublication;
	}
	public void setDateOfPublication(Date dateOfPublication) {
		this.dateOfPublication = dateOfPublication;
	}
}
