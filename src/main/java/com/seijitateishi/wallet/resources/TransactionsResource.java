package com.seijitateishi.wallet.resources;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.seijitateishi.wallet.domain.Transactions;
import com.seijitateishi.wallet.dto.TransactionDTO;
import com.seijitateishi.wallet.services.TransactionsService;

@RestController
public class TransactionsResource {

	@Autowired
	private TransactionsService transactionsService;
	
	@GetMapping("/{id}")
	public ResponseEntity<TransactionDTO> findById(@PathVariable String id){
		Optional<Transactions> transaction = transactionsService.findById(id);
		
		var transactionDTO = new TransactionDTO(transaction.get());
		
		return ResponseEntity.ok().body(transactionDTO);
	}
}
