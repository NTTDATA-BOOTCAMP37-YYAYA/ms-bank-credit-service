package com.nttdata.bootcamp.msbankcredit.domain.enums;

public enum CreditProduct {

    BANKCREDIT("4","Credito Bancario"),
    CREDITCARD("5","Tarjeta de Credito");

    private final String value;
    private final String name;

    CreditProduct(String value,String name) {
        this.value = value;
        this.name=name;
    }
    
    public String getValue() {
     return value;
  	}

	public String getName() {
		return name;
	}

    
}
