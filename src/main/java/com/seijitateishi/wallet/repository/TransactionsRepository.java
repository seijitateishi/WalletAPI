package com.seijitateishi.wallet.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.seijitateishi.wallet.domain.Transactions;

@Repository
public interface TransactionsRepository extends MongoRepository<Transactions,String>{

}
