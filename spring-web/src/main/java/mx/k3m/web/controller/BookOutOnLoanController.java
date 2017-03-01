package mx.k3m.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import k3m.mx.entities.BookOutOnLoan;
import k3m.mx.service.BookOutOnLoanService;

@Controller
public class BookOutOnLoanController {
	
	@Autowired
	BookOutOnLoanService bookOutOnLoanService;
	
	@GetMapping	
	@RequestMapping(value = {"/bookOutOnLoan"})
	public String loadPage(ModelMap model){
		
		model.addAttribute("bookOutOnLoan", new BookOutOnLoan());
		return "bookOutOnLoan";
	}

	
	@PostMapping
	@RequestMapping(value = {"/bookOutOnLoan/search"})
	public String search(@ModelAttribute("bookOutOnLoan") BookOutOnLoan bookOutOnLoan, ModelMap model){
		
		bookOutOnLoan = bookOutOnLoanService.findByIdNotLazy(bookOutOnLoan.getIdBookBorrowing());
		if (bookOutOnLoan.getIdBookBorrowing() == null || bookOutOnLoan.getIdBookBorrowing() == 0)
			return "redirect:/bookOutOnLoan";
		
		model.addAttribute("bookOutOnLoan", bookOutOnLoan);
		return "bookOutOnLoanEdit";
	}
	
	@GetMapping
	@RequestMapping(value = {"/bookOutOnLoan/create"})
	public String goToCreate(ModelMap model){
		model.addAttribute("bookOutOnLoan", new BookOutOnLoan());
		return "bookOutOnLoanEdit";
	}
	
	@PostMapping
	@RequestMapping(value = {"/bookOutOnLoan/save"})
	public String save(@ModelAttribute("bookOutOnLoan") BookOutOnLoan bookOutOnLoan,  ModelMap model){
		
		
		bookOutOnLoanService.saveOrEdit(bookOutOnLoan);
		
		return "redirect:/bookOutOnLoan";
	}
	
	@PostMapping
	@RequestMapping(value = {"/bookOutOnLoan/delete"})
	public String delete(@ModelAttribute("bookOutOnLoan") BookOutOnLoan bookOutOnLoan,  ModelMap model){
		bookOutOnLoanService.delete(bookOutOnLoan.getIdBookBorrowing());
		return "redirect:/bookOutOnLoan";
	}
}
 