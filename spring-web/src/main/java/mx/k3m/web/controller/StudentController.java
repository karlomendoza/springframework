package mx.k3m.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import k3m.mx.entities.Student;
import k3m.mx.service.StudentService;

@Controller
public class StudentController {
	
	@Autowired
	StudentService studentService;
	
	@GetMapping	
	@RequestMapping(value = {"/student"})
	public String loadPage(ModelMap model){
		
		model.addAttribute("student", new Student());
		return "student";
	}

	
	@PostMapping
	@RequestMapping(value = {"/student/search"})
	public String search(@ModelAttribute("student") Student student, ModelMap model){
		
		
		student = studentService.findById(student.getIdStudent());
		if (student.getIdStudent() == null || student.getIdStudent() == 0)
			return "redirect:/student";
		
		model.addAttribute("student", student);
		return "studentEdit";
	}
	
	@GetMapping
	@RequestMapping(value = {"/student/create"})
	public String goToCreate(ModelMap model){
		model.addAttribute("student", new Student());
		return "studentEdit";
	}
	
	@PostMapping
	@RequestMapping(value = {"/student/save"})
	public String save(@ModelAttribute("student") Student student,  ModelMap model){
		studentService.saveOrEdit(student);
		
		return "redirect:/student";
		//return "student";
	}
	
	@PostMapping
	@RequestMapping(value = {"/student/delete"})
	public String delete(@ModelAttribute("student") Student student,  ModelMap model){
		studentService.delete(student.getIdStudent());
		return "redirect:/student";
	}
}
 