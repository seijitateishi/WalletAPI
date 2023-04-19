package com.seijitateishi.wallet.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seijitateishi.wallet.domain.Transactions;
import com.seijitateishi.wallet.repository.TransactionsRepository;

@Service
public class TransactionsService {

	@Autowired
	TransactionsRepository repo;
	
	public Optional<Transactions> findById(String id){
		return repo.findById(id);
	}
	
}
