package mx.k3m.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import k3m.mx.entities.Book;
import k3m.mx.service.BookService;

@Controller
public class BookController {
	
	@Autowired
	BookService bookService;
	
	@GetMapping	
	@RequestMapping(value = {"/book"})
	public String loadPage(ModelMap model){
		
		model.addAttribute("book", new Book());
		return "book";
	}

	@PostMapping
	@RequestMapping(value = {"/book/search"})
	public String search(@ModelAttribute("book") Book book, ModelMap model){
		book = bookService.findById(book.getIsbn());
		if (book.getIsbn() == null || book.getIsbn() == "")
			return "redirect:/book";
		
		model.addAttribute("book", book);
		return "bookEdit";
	}
	
	@GetMapping
	@RequestMapping(value = {"/book/create"})
	public String goToCreate(ModelMap model){
		model.addAttribute("book", new Book());
		return "bookEdit";
	}
	
	@PostMapping
	@RequestMapping(value = {"/book/save"})
	public String save(@ModelAttribute("book") Book book,  ModelMap model){
		
		bookService.saveOrEdit(book);
		
		return "redirect:/book";
	}
	
	@PostMapping
	@RequestMapping(value = {"/book/delete"})
	public String delete(@ModelAttribute("book") Book book,  ModelMap model){
		bookService.delete(book.getIsbn());
		return "redirect:/book";
	}
}
 