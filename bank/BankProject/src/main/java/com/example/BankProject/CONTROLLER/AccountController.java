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

import com.example.BankProject.DAO.AccountDao;
import com.example.BankProject.DTO.Account;


@RestController
@RequestMapping("/account")
public class AccountController 
{
	@Autowired
	AccountDao accdao;
	
	@PostMapping
	public ResponseEntity<Account> addAccount(@RequestBody Account acc,int id)
	{
		Account a=accdao.addAccount(acc, id);
		return ResponseEntity.ok(a);
	}
	
	@GetMapping
	public ResponseEntity<List<Account>> findAll()
	{
		List<Account> list=accdao.FetchAll();
		return ResponseEntity.ok(list);
	}
	
	@GetMapping("/byid")
	public ResponseEntity<Account> searchById(@RequestParam int id)
	{
		Account acc=accdao.searchById(id);
		if(acc!=null)
		{
			return ResponseEntity.ok(acc);
		}
		else
		{
			return ResponseEntity.notFound().build();
		}
	}
	
	
	@PutMapping
	public ResponseEntity<Account> updateAccount(@RequestParam int id,String account_name,double balance,String ifsc_code)
	{
		Account acc=accdao.updateAccount(id, account_name, balance, ifsc_code);
		if(acc!=null)
		{
			return ResponseEntity.ok(acc);
		}
		return ResponseEntity.notFound().build();
		
	}
	
	@DeleteMapping
	public ResponseEntity<Void> deleteAccount(@RequestParam int id)
	{
		int a=accdao.removeAccount(id);
		if(a==1)
		{
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
