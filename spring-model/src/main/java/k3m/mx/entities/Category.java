package k3m.mx.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="category")
public class Category {
	@Id
	@Column(name="idCategory")
	private Integer idCategory;
	
	@Column(name="name")
	private String name;
	
	@Column(name="description")
	private String description;
	
	public Category(){	
		
	}

	public Category(Integer idCategory, String name, String description) {
		this.idCategory = idCategory;
		this.name = name;
		this.description = description;
	}

	@Override
	public String toString() {
		return "Category [idCategory=" + idCategory + ", name=" + name + ", description=" + description + "]";
	}

	public Integer getIdCategory() {
		return idCategory;
	}

	public void setIdCategory(Integer idCategory) {
		this.idCategory = idCategory;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	
	
}
