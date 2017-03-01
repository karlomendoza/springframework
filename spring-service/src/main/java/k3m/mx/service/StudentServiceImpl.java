package k3m.mx.service;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import k3m.mx.entities.Student;
import k3m.mx.repository.StudentRepository;

@Service("studentService")
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentRepository studentRepository;
	
	@Override
	@Transactional
	public Student findById(Integer idStudent) {
		if(idStudent == null || idStudent == 0)
			return null;
		
		Student student;
		try{
			student = studentRepository.getOne(idStudent);
			student.getIdStudent();
		} catch(EntityNotFoundException ex){
			student = new Student();
			//no entity found return empty object
		}
		return student;
	}

	@Override
	public int delete(Integer idStudent) {
		if(idStudent == null || idStudent == 0)
			return 0;
		
		studentRepository.delete(idStudent);
		return 1;
	}

	@Override
	public void saveOrEdit(Student student) {
		studentRepository.save(student);
	}

}
