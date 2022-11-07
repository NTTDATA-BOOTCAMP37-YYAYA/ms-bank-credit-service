package com.nttdata.bootcamp.msbankcredit.infrastructure.web.rest.adapter;



import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nttdata.bootcamp.msbankcredit.application.incoming.CreateCreditUseCase;
import com.nttdata.bootcamp.msbankcredit.application.incoming.FindCreditByCustIdAndProdIdUseCase;
import com.nttdata.bootcamp.msbankcredit.domain.model.Credit;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/credit")
public class CreditControllerAdapter {

	final Logger logger= LoggerFactory.getLogger(CreditControllerAdapter.class);
	
	@Autowired
	private  FindCreditByCustIdAndProdIdUseCase findCreditByCustIdAndProdIdUseCase;
	
	@Autowired
	private  CreateCreditUseCase createCreditUseCase;
	
	@PostMapping
	public Mono<ResponseEntity<Credit>> createCredit( @RequestBody Credit credit){	
		return createCreditUseCase.createAccount(credit).map(ResponseEntity::ok)
				  .defaultIfEmpty(ResponseEntity.notFound().build())
	    		 .doOnNext(p->{
	    			if( p.getBody()==null) {
	    				logger.info("Final process createCredit - It's not been created");
	    			}else {
	    				logger.info("Final process createCredit - It's been created");
	    			}
	    		 });
	}
	
	
	@GetMapping("/productOneCustomer/{customerId}/{productId}")
	public Flux<Credit> findCreditByCustIdAndProdId(
			@PathVariable("customerId") String customerId,
			@PathVariable("productId") String productId){	
		return findCreditByCustIdAndProdIdUseCase.findCreditByCustIdAndProdId(customerId, productId);
	}
	
	@GetMapping("/creditDebts/{customerId}")
	public Flux<Credit> findDebtCustomer(@PathVariable("customerId") String customerId){
		//TODO solo activas
		List<Credit> lista= new ArrayList<Credit>();
		Credit credit1 = new Credit();
		credit1.setCreditId("1");
		Credit credit2 = new Credit();
		credit2.setCreditId("2");
		lista.add(credit1);
		lista.add(credit2);
		//Flux<Credit> flux=Flux.just(lista).flatMap(Flux::fromIterable);
		
		
		return Flux.empty();
	}
	
	@GetMapping("/creditCards/{customerId}")
	public Flux<Credit> findCreditCards(@PathVariable("customerId") String customerId){
		//TODO solo activos
		List<Credit> lista= new ArrayList<Credit>();
		Credit credit1 = new Credit();
		credit1.setCreditId("1");
		lista.add(credit1);
		Flux<Credit> flux=Flux.just(lista).flatMap(Flux::fromIterable);
		
		
		return flux;
	}
	
}
