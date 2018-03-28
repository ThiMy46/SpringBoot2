package com.daomy.service;


import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.daomy.dao.AccountRepository;
import com.daomy.model.Account;

@Service
@Transactional
public class AccountService implements AccountRe{
	private final AccountRepository accRepository;

	public AccountService(AccountRepository accRepository) {
		this.accRepository = accRepository;
	}
	
	public List<Account> findAllAcc(){
		List<Account> acc=new ArrayList<Account>();
		for(Account account:accRepository.findAll()){
			acc.add(account);
		}
		return acc;
	}

	@Override
	public Account findByAccountnameAndPassword(String accountname, String password) {
		return accRepository.findByAccountnameAndPassword(accountname, password);
	}

}
