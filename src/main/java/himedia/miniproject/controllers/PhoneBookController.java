package himedia.miniproject.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import himedia.miniproject.repositories.PhonebookVo;
import himedia.miniproject.services.PhonebookService;

@RequestMapping("/phonebook")
@Controller
public class PhoneBookController {

	@Autowired
	private PhonebookService phonebookService;
	
	@RequestMapping({"", "/", "/list"})
	public String list(Model model) {
		List<PhonebookVo> list = phonebookService.getList();
		model.addAttribute("list", list);
		return "phonebook/list";
	}
	
	
	
	
}
