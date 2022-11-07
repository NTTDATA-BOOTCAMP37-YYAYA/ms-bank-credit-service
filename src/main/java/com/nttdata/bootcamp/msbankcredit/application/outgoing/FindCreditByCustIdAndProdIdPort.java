package com.nttdata.bootcamp.msbankcredit.application.outgoing;

import com.nttdata.bootcamp.msbankcredit.domain.model.Credit;

import reactor.core.publisher.Flux;

public interface FindCreditByCustIdAndProdIdPort {

	Flux<Credit> findCreditByCustIdAndProdId(String customerId, String productId);
}
