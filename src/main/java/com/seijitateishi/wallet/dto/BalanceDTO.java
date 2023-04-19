package com.seijitateishi.wallet.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import com.seijitateishi.wallet.domain.Wallet;

public class BalanceDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String holderName;
	private BigDecimal balance;
	
	public BalanceDTO(Wallet wallet) {
		super();
		this.holderName = wallet.getHolderName();
		this.balance = wallet.getBalance();
	}
	
	public String getHolderName() {
		return holderName;
	}
	
	public BigDecimal getBalance() {
		return balance;
	}
	
	
}
