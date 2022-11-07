package com.nttdata.bootcamp.msbankcredit.infrastructure.persistence.entity;

import org.springframework.beans.BeanUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.nttdata.bootcamp.msbankcredit.domain.model.Credit;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document (collection = "Credit")
public class CreditEntity {

	@Id
	private String creditId;
	private String customerId;
	private String productId;
	private String creditTotalPending;
	private String creditTotalPaid;

	
	public static Credit toCredit(CreditEntity creditEntity){
		Credit credit = new Credit();
		BeanUtils.copyProperties(creditEntity , credit);
		return credit;
	}
	
	public static CreditEntity toCreditEntity(Credit credit){
		
		CreditEntity creditEntity = new CreditEntity();
		BeanUtils.copyProperties(credit , creditEntity);
		return creditEntity;
	}
}
