package com.example.demo.service.imply;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.models.payment;
import com.example.demo.repository.paymentRepo;
import com.example.demo.service.paymentService;

@Service
public class paymentServiceImply implements paymentService {
	@Autowired
	paymentRepo repo;

	@Override
	public payment addPayment(payment p) {
		
		return repo.save(p);
	}

	@Override
	public List<payment> getPayments() {
		
		return repo.findAll();
	}

	@Override
	public payment getSinglePayment(long id) {
		
		return repo.findById(id).orElseThrow(()->new ResourceNotFoundException("payment not found" + id));
	}

	@Override
	public String deletebyid(long id) {
		
		repo.deleteById(id);
		return "id is deleted successfully :" +id;
	}

	@Override
	public payment updatePayment(payment p, long id) {
		payment p1=getSinglePayment(id);
		p1.setPaymentMethod(p.getPaymentMethod());
		p1.setPaymentAddress(p.getPaymentAddress());
		p1.setPaymentPin(p.getPaymentPin());
		p1.setStatus(p.isStatus());
		return repo.save(p1);
	}

}
