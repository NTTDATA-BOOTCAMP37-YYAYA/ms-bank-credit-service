package com.nttdata.bootcamp.msbankcredit.application.incoming;

import com.nttdata.bootcamp.msbankcredit.domain.model.Credit;

import reactor.core.publisher.Mono;

public interface CreateCreditUseCase {

	Mono<Credit> createAccount(Credit credit);
}
