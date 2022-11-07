package com.nttdata.bootcamp.msbankcredit.application.incoming;

import com.nttdata.bootcamp.msbankcredit.domain.model.Credit;

import reactor.core.publisher.Flux;

public interface FindCreditByCustIdAndProdIdUseCase {

	Flux<Credit> findCreditByCustIdAndProdId(String customerId,String productId);
}
