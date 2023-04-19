package com.seijitateishi.wallet.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import com.seijitateishi.wallet.domain.Wallet;

public class WalletDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String holderName;
	private BigDecimal balance;
	private List<TransactionDTO> transactions;
	
	public WalletDTO(Wallet wallet) {
		super();
		this.holderName = wallet.getHolderName();
		this.balance = wallet.getBalance();
		this.transactions = wallet.getTransactions() != null ? wallet.getTransactions().stream()
				.map(TransactionDTO::new)
				.toList() : null;
	}
	
	public String getHolderName() {
		return holderName;
	}
	
	public BigDecimal getBalance() {
		return balance;
	}

	public List<TransactionDTO> getTransactions() {
		return transactions;
	}

	
	
}
