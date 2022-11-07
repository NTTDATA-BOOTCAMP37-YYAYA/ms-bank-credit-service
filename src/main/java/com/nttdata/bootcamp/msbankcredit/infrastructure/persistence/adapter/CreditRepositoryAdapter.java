package com.nttdata.bootcamp.msbankcredit.infrastructure.persistence.adapter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nttdata.bootcamp.msbankcredit.application.outgoing.CreateCreditPort;
import com.nttdata.bootcamp.msbankcredit.application.outgoing.FindCreditByCustIdAndProdIdPort;
import com.nttdata.bootcamp.msbankcredit.domain.model.Credit;
import com.nttdata.bootcamp.msbankcredit.infrastructure.persistence.entity.CreditEntity;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class CreditRepositoryAdapter implements FindCreditByCustIdAndProdIdPort,CreateCreditPort{


	@Autowired
	private ReactiveMongoCreditRepository reactiveMongoDB;


	@Override
	public Flux<Credit> findCreditByCustIdAndProdId(String customerId,String productId ) {
		return reactiveMongoDB.findCreditByCustIdAndProdId(customerId,productId)
				.map(CreditEntity::toCredit);
	}


	@Override
	public Mono<Credit> createAccount(Credit credit) {
		 return reactiveMongoDB.insert(CreditEntity.toCreditEntity(credit))
			      .map(CreditEntity::toCredit);
	}


}
