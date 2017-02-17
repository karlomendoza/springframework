package k3m.mx.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import k3m.mx.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, String> {
	public List<Category> findByName(String name);
}
