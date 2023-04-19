package com.seijitateishi.wallet.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.seijitateishi.wallet.domain.Transactions;
import com.seijitateishi.wallet.domain.Wallet;

public class TransactionDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private BigDecimal amount;
	private LocalDateTime date;
	
	public TransactionDTO(Transactions transaction) {
		this.amount = transaction.getValue();
		this.date = transaction.getTime();
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}
}
