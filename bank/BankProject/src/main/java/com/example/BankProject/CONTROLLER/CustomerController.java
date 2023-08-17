package com.example.BankProject.CONTROLLER;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.BankProject.DAO.CustomerDao;
import com.example.BankProject.DTO.Customer;

@RestController
@RequestMapping("/customer")
public class CustomerController
{
	@Autowired
	CustomerDao cusdao;
	

	@PostMapping
	public ResponseEntity<Customer> addCustomer(@RequestBody Customer cus,@RequestParam int id)
	{
		Customer c=cusdao.addcustomer(cus, id);
		return ResponseEntity.ok(c);
		
	}
	
	@GetMapping
	public ResponseEntity<List<Customer>> findAll()
	{
		List<Customer> list=cusdao.FetchAll();
		return ResponseEntity.ok(list);
	}
	
	@GetMapping("/byid")
	public ResponseEntity<Customer> searchById(@RequestParam int id)
	{
		Customer cus=cusdao.searchById(id);
		if(cus!=null)
		{
			return ResponseEntity.ok(cus);
		}
		else
		{
			return ResponseEntity.notFound().build();
		}
	}
	
	@PutMapping
	public ResponseEntity<Customer> updateCustomer(@RequestParam int id,long customer_id,String name,String address,long phone_no)
	{
		Customer cus=cusdao.updateCustomer(id, customer_id, name, address, phone_no);
		if(cus!=null)
		{
			return ResponseEntity.ok(cus);
		}
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping
	public ResponseEntity<Void> deleteCustomer(@RequestParam int id)
	{
		int a=cusdao.removeCustomer(id);
		if(a==1)
		{
			return ResponseEntity.ok().build();
		}
		else
		{
			return ResponseEntity.notFound().build();
		}
	}
	

}





















