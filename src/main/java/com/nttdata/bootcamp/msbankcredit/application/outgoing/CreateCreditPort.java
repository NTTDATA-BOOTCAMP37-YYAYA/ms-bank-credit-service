package com.nttdata.bootcamp.msbankcredit.application.outgoing;

import com.nttdata.bootcamp.msbankcredit.domain.model.Credit;

import reactor.core.publisher.Mono;

public interface CreateCreditPort {

	Mono<Credit> createAccount(Credit credit);
}
