package mx.k3m.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import k3m.mx.entities.Category;
import k3m.mx.service.CategoryService;

@Controller
public class CategoryController {
	
	@Autowired
	CategoryService categoryService;
	
	@GetMapping	
	@RequestMapping(value = {"/category"})
	public String loadPage(ModelMap model){
		
		model.addAttribute("category", new Category());
		return "category";
	}

	
	@PostMapping
	@RequestMapping(value = {"/category/search"})
	public String search(@ModelAttribute("category") Category category, ModelMap model){
		
		
		category = categoryService.findById(category.getIdCategory());
		if (category.getIdCategory() == null || category.getIdCategory() == 0)
			return "redirect:/category";
		
		model.addAttribute("category", category);
		return "categoryEdit";
	}
	
	@GetMapping
	@RequestMapping(value = {"/category/create"})
	public String goToCreate(ModelMap model){
		model.addAttribute("category", new Category());
		return "categoryEdit";
	}
	
	@PostMapping
	@RequestMapping(value = {"/category/save"})
	public String save(@ModelAttribute("category") Category category,  ModelMap model){
		categoryService.saveOrEdit(category);
		
		return "redirect:/category";
		//return "category";
	}
	
	@PostMapping
	@RequestMapping(value = {"/category/delete"})
	public String delete(@ModelAttribute("category") Category category,  ModelMap model){
		categoryService.delete(category.getIdCategory());
		return "redirect:/category";
	}
}
 