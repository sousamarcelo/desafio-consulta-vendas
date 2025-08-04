package com.devsuperior.dsmeta.dto;

import com.devsuperior.dsmeta.projections.SaleSumProjection;

public class SaleSumDTO {
	
	private String sellerName;
	private Long total;
	
	public SaleSumDTO() {
	}

	public SaleSumDTO(String sellerName, Long total) {
		super();
		this.sellerName = sellerName;
		this.total = total;
	}
	
	public SaleSumDTO(SaleSumProjection projection) {
		this.sellerName = projection.getSellerName();
		this.total = projection.getSum();
	}

	public String getSellerName() {
		return sellerName;
	}

	public Long getTotal() {
		return total;
	}
}
