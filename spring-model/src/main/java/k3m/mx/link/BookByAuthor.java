package k3m.mx.link;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity(name="books_by_author")
public class BookByAuthor {
	
	@EmbeddedId
	private PK pk;
	
	public PK getPk() {
		return pk;
	}

	public void setPk(PK pk) {
		this.pk = pk;
	}

	@Embeddable
	public static class PK implements Serializable{
		
		private static final long serialVersionUID = 1L;

		private int idAuthor;
		
		private String isbn;

		public int getIdAuthor() {
			return idAuthor;
		}

		public void setIdAuthor(int idAuthor) {
			this.idAuthor = idAuthor;
		}

		public String getIsbn() {
			return isbn;
		}

		public void setIsbn(String isbn) {
			this.isbn = isbn;
		}
	}

}
