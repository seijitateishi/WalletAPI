package com.seijitateishi.wallet.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "wallets")
public class Wallet implements Serializable	{
	private static final long serialVersionUID = 1L;

	@Id
	private String id;
	private String holderName;
	private BigDecimal balance;

	@DBRef
	private List<Transactions> transactions;
	
	public Wallet() {
	}

	public Wallet( String holderName) {
		super();
		this.holderName = holderName;
		this.balance = BigDecimal.ZERO;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getHolderName() {
		return holderName;
	}

	public void setHolderName(String holderName) {
		this.holderName = holderName;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Wallet other = (Wallet) obj;
		return Objects.equals(id, other.id);
	}
	
	public void addTransaction(Transactions transaction) {
		if (this.transactions == null) 
			setTransactions(new ArrayList<>());
		this.transactions.add(transaction);
	}

	public List<Transactions> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<Transactions> transactions) {
		this.transactions = transactions;
	}
	
	
	
}
