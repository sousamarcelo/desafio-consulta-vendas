package com.devsuperior.dsmeta.dto;

import com.devsuperior.dsmeta.entities.Sale;

public class SaleReportDTO {
	
	private Long id;
	private String date;
	private Double amount;
	private String sellerName;
	
	public SaleReportDTO() {
	}

	public SaleReportDTO(Long id, String date, Double amount, String sellername) {
		this.id = id;
		this.date = date;
		this.amount = amount;
		this.sellerName = sellername;
	}
	
	public SaleReportDTO(Sale entity) {
		id = entity.getId();
		date = String.valueOf(entity.getDate());
		amount = entity.getAmount();
		sellerName = entity.getSeller().getName();
	}

	public Long getId() {
		return id;
	}

	public String getDate() {
		return date;
	}

	public Double getAmount() {
		return amount;
	}

	public String getSellerName() {
		return sellerName;
	}
}
