package com.nttdata.bootcamp.msbankcredit.domain.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nttdata.bootcamp.msbankcredit.application.incoming.CreateCreditUseCase;
import com.nttdata.bootcamp.msbankcredit.application.incoming.FindCreditByCustIdAndProdIdUseCase;
import com.nttdata.bootcamp.msbankcredit.application.incoming.FindCreditCardsUseCase;
import com.nttdata.bootcamp.msbankcredit.application.outgoing.CreateCreditPort;
import com.nttdata.bootcamp.msbankcredit.application.outgoing.FindCreditByCustIdAndProdIdPort;
import com.nttdata.bootcamp.msbankcredit.domain.enums.CreditProduct;
import com.nttdata.bootcamp.msbankcredit.domain.model.Credit;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Service
public class CreditService implements FindCreditByCustIdAndProdIdUseCase,CreateCreditUseCase,FindCreditCardsUseCase {
	
  final  Logger logger = LoggerFactory.getLogger(CreditService.class);
	
	@Autowired
	private FindCreditByCustIdAndProdIdPort findCreditByCustIdAndProdIdPort;
	
	@Autowired
	private CreateCreditPort createCreditPort;
	

	@Override
	public Flux<Credit> findCreditByCustIdAndProdId(String customerId,String productId) {
	  return findCreditByCustIdAndProdIdPort.findCreditByCustIdAndProdId(customerId, productId);
	}

	@Override
	public Mono<Credit> createAccount(Credit credit) {
		return createCreditPort.createAccount(credit);
	}

	@Override
	public Flux<Credit> findCreditCards(String customerId) {
		return findCreditByCustIdAndProdIdPort.findCreditByCustIdAndProdId(customerId, CreditProduct.CREDITCARD.getValue());
	}





	
}
