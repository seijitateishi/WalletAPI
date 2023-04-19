package com.seijitateishi.wallet.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.seijitateishi.wallet.domain.Wallet;
@Repository
public interface WalletRepository extends MongoRepository<Wallet, String> {

	Wallet searchById(String id);
	
	List<Wallet> findAll();
}
