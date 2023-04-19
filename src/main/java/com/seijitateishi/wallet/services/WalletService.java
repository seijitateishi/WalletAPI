package com.seijitateishi.wallet.services;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seijitateishi.wallet.domain.Transactions;
import com.seijitateishi.wallet.domain.Wallet;
import com.seijitateishi.wallet.repository.TransactionsRepository;
import com.seijitateishi.wallet.repository.WalletRepository;

@Service
public class WalletService {
	
	@Autowired
	WalletRepository repo;
	
	@Autowired
	TransactionsRepository transactionsRepository;
	
	public void save(Wallet wallet) {
		repo.insert(wallet);
	}
	
	public Optional<Wallet> findById(String id) {
		return repo.findById(id);
	}
	
	public void deposit(Wallet wallet,BigDecimal value) {
		wallet.setBalance(wallet.getBalance().add(value));
		LocalDateTime time = LocalDateTime.now();
		Transactions transaction = new Transactions(wallet, value, time);
		wallet.addTransaction(transaction);
		transactionsRepository.saveAll(wallet.getTransactions());
		repo.save(wallet);
	}
	
	public boolean withdraw(Wallet wallet,BigDecimal value) {
		if (value.compareTo(wallet.getBalance()) == 1) {
			return false;
		}
		wallet.setBalance(wallet.getBalance().subtract(value));
		LocalDateTime time = LocalDateTime.now();
		Transactions transaction = new Transactions(wallet, value.negate(), time);
		wallet.addTransaction(transaction);
		transactionsRepository.saveAll(wallet.getTransactions());
		repo.save(wallet);
		return true;
	}
}
