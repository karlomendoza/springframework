package k3m.mx.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import k3m.mx.entities.Student;

public interface StudentRepository extends JpaRepository<Student, String> {

}
