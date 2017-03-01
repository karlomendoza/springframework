package mx.k3m.web.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import k3m.mx.entities.Author;
import k3m.mx.entities.Book;
import k3m.mx.service.AuthorService;
import k3m.mx.service.BookService;

@Controller
public class AuthorController {

	@Autowired
	AuthorService authorService;

	@Autowired
	BookService bookService;

	@GetMapping
	@RequestMapping(value = { "/author" })
	public String loadPage(ModelMap model) {

		model.addAttribute("author", new Author());
		return "author";
	}

	@PostMapping
	@RequestMapping(value = { "/author/search" })
	public String search(@ModelAttribute("author") Author author, ModelMap model) {

		

		author = authorService.findByIdNotLazy(author.getIdAuthor());
		if (author.getIdAuthor() == null || author.getIdAuthor() == 0)
			return "redirect:/author";

		if (author.getBooks() != null && !author.getBooks().isEmpty()) {
			author.setIsbns(author.getBooks().stream().map(Book::getIsbn).collect(Collectors.joining(",")));
		}
		
		model.addAttribute("author", author);
		return "authorEdit";
	}

	@GetMapping
	@RequestMapping(value = { "/author/create" })
	public String goToCreate(ModelMap model) {
		model.addAttribute("author", new Author());
		return "authorEdit";
	}

	@PostMapping
	@RequestMapping(value = { "/author/save" })
	public String save(@ModelAttribute("author") Author author, ModelMap model) {

		List<Book> books = bookService.findBooksByIsbns(author.getIsbns());

		author.setBooks(books);
		
		authorService.saveOrEdit(author);

		return "redirect:/author";
		// return "author";
	}

	@PostMapping
	@RequestMapping(value = { "/author/delete" })
	public String delete(@ModelAttribute("author") Author author, ModelMap model) {
		authorService.delete(author.getIdAuthor());
		return "redirect:/author";
	}
}
