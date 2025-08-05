package com.devsuperior.dsmeta.dto;

import com.devsuperior.dsmeta.projections.SaleSumProjection;

public class SaleSumDTO {
	
	private String name;
	private Long sum;
	
	public SaleSumDTO() {
	}

	public SaleSumDTO(String name, Long sum) {
		this.name = name;
		this.sum = sum;
	}
	
	public SaleSumDTO(SaleSumProjection projection) {
		name = projection.getName();
		sum = projection.getSum();
	}

	public String getName() {
		return name;
	}

	public Long getSum() {
		return sum;
	}

	@Override
	public String toString() {
		return "SaleSumDTO [name=" + name + ", sum=" + sum + "]";
	}
	
}
