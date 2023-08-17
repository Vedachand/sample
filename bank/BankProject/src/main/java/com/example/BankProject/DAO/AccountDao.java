package com.example.BankProject.DAO;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.BankProject.DTO.Account;
import com.example.BankProject.DTO.Branch;
import com.example.BankProject.REPOSITORY.AccountRepository;
import com.example.BankProject.REPOSITORY.BranchRepository;

@Repository
public class AccountDao 
{
	@Autowired
	AccountRepository acc;
	
	@Autowired
	BranchDao branch;
	
	public Account addAccount(Account account,int id)
	{
		Branch b=branch.searchById(id);
		if(b!=null)
		{
			List<Account> list=new ArrayList<>();
			b.setAccount(list);
			return acc.save(account);
		}
		return null; 	
	}
	
	public Account searchById(int id)
	{
		Optional<Account> opt=acc.findById(id);
		if(opt.isPresent())
		{
			return opt.get();
		}
		return null;	
	}
	
	public List<Account> FetchAll()
	{
		return acc.findAll();
	}
	
	public int removeAccount(int id)
	{
		Account acc1=searchById(id);
		if(acc1!=null)
		{
			acc.deleteById(id);
			return 1;
		}
		return 0;
	}
	
	public Account updateAccount(int id,String account_name,double balance,String ifsc_code)
	{
		Account acc1=searchById(id);
		if(acc1!=null)
		{
			acc1.setAccount_name(account_name);
			acc1.setBalance(balance);
			acc1.setIfsc_code(ifsc_code);
			acc.save(acc1);
			return acc1;
		}
		return null;
	}
	

}
