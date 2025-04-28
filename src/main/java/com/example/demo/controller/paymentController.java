package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.models.payment;
import com.example.demo.service.paymentService;

@Controller
@RequestMapping("/payments")
public class paymentController {
	@Autowired
	paymentService service;
	
	@GetMapping("/")
	public String welcome() {
		return "index";
	}
	
	@GetMapping()
	public String getAllPayments(Model m)
	{
		List<payment> li=service.getPayments();
		m.addAttribute("payments",li);
         return "allPayments";
     }
	@GetMapping("/add")
	public String addForm(Model m) {
		m.addAttribute("payment",new payment());
		return "addPayment";
	}
	@PostMapping("/add")	
     public String addPayment(@ModelAttribute payment p) {
    	 service.addPayment(p);
    	 return "redirect:/payments";
     }

	@GetMapping("/delete/{id}")
	public String deletePayment(@PathVariable long id) {
		service.deletebyid(id);
		return "redirect:/payments";
		
	}

 
	@GetMapping("/update/{id}")
   public String updateForm(@PathVariable long id, Model m) {
	   payment p=service.getSinglePayment(id);
	   m.addAttribute("payment",p);
	   return "updatePayment";
	   
	   
   }
	@PostMapping("/update/{id}")
	public String updatePayment(@ModelAttribute  payment p,@PathVariable long id) {
		service.updatePayment(p, id);
		return "redirect:/payments";
	}


}
