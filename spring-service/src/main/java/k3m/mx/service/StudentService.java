package k3m.mx.service;

import k3m.mx.entities.Student;

public interface StudentService {
	public Student findById(Integer idStudent);
	
	public int delete(Integer idStudent);
	
	public void saveOrEdit(Student student);

}
