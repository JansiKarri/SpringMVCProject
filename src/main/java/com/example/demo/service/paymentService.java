package com.example.demo.service;

import java.util.List;

import com.example.demo.models.payment;


public interface paymentService {
	public payment addPayment(payment p);
	public List<payment> getPayments();
	public payment getSinglePayment(long id);
	public String deletebyid(long id);
	public payment updatePayment(payment p,long id);
	
	

}
