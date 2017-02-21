package k3m.mx.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import k3m.mx.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
