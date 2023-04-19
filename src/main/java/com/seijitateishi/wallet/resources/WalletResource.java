package com.seijitateishi.wallet.resources;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.seijitateishi.wallet.domain.Wallet;
import com.seijitateishi.wallet.dto.WalletDTO;
import com.seijitateishi.wallet.services.WalletService;

@RestController
@RequestMapping(value ="/wallets")
public class WalletResource {
	
	
	@Autowired
	private WalletService walletService;
	
	@GetMapping("/{id}")
	public ResponseEntity<WalletDTO> findById(@PathVariable String id){
		Optional<Wallet> wallet = walletService.findById(id);	
		
		var walletDTO = new WalletDTO(wallet.get());
		
		return ResponseEntity.ok().body(walletDTO);
	}
	
	@PostMapping
	public ResponseEntity<WalletDTO> createWallet(@RequestParam(required = true) String holderName){
		Wallet newWallet = new Wallet(holderName);
		
		walletService.save(newWallet);
		
		WalletDTO newWalletDTO = new WalletDTO(newWallet);
		
		return ResponseEntity.ok().body(newWalletDTO);
	}
	
	@PostMapping("/deposit")
	public ResponseEntity<Void> deposit(@RequestParam(required = true) BigDecimal value,@RequestParam(required = true)String id){
		Optional<Wallet> walletAux = walletService.findById(id);
		if(walletAux.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		walletService.deposit(walletAux.get(), value);
		return ResponseEntity.ok().build();
	}
	
	@PostMapping("/withdraw")
	public ResponseEntity<Void> withdraw(@RequestParam(required = true) BigDecimal value,@RequestParam(required = true)String id){
		Optional<Wallet> walletAux = walletService.findById(id);
		if(walletAux.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		if (!walletService.withdraw(walletAux.get(), value)) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		return ResponseEntity.ok().build();
	}
}
