package com.nttdata.bootcamp.msbankcredit.infrastructure.persistence.adapter;


import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.nttdata.bootcamp.msbankcredit.infrastructure.persistence.entity.CreditEntity;

import reactor.core.publisher.Flux;

public interface ReactiveMongoCreditRepository extends ReactiveMongoRepository<CreditEntity, String>{


	@Query("{'customerId': ?0,'productId' : ?1}")
	public Flux<CreditEntity> findCreditByCustIdAndProdId(String customerId,String productId);

}