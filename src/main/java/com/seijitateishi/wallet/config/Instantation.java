package com.seijitateishi.wallet.config;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.seijitateishi.wallet.domain.Transactions;
import com.seijitateishi.wallet.domain.Wallet;
import com.seijitateishi.wallet.repository.TransactionsRepository;
import com.seijitateishi.wallet.repository.WalletRepository;
import com.seijitateishi.wallet.services.TransactionsService;
import com.seijitateishi.wallet.services.WalletService;

@Configuration
public class Instantation implements CommandLineRunner	{
	
	@Autowired
	private WalletRepository walletRepository;
	
	@Autowired
	private WalletService walletService;
	
	@Autowired
	private TransactionsRepository transactionsRepository;
	
	@Autowired
	private TransactionsService transactionsService;
	
	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf =new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		walletRepository.deleteAll();
		transactionsRepository.deleteAll();
		
		Wallet wallets = new Wallet("seiji");
		walletRepository.saveAll(Arrays.asList(wallets));
		System.out.println(walletRepository.findById(wallets.getId()));
		walletService.deposit(wallets, new BigDecimal (2000));
		walletService.withdraw(wallets, new BigDecimal (1000));
		walletService.withdraw(wallets, new BigDecimal (500));
	}
}
