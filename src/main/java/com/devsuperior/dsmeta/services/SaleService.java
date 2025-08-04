package com.devsuperior.dsmeta.services;


import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.devsuperior.dsmeta.dto.SaleMinDTO;
import com.devsuperior.dsmeta.dto.SaleReportDTO;
import com.devsuperior.dsmeta.dto.SaleSumDTO;
import com.devsuperior.dsmeta.entities.Sale;
import com.devsuperior.dsmeta.projections.SaleSumProjection;
import com.devsuperior.dsmeta.repositories.SaleRepository;

@Service
public class SaleService {
	
	private static final LocalDate today = LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault());

	@Autowired
	private SaleRepository repository;
	
	public SaleMinDTO findById(Long id) {
		Optional<Sale> result = repository.findById(id);
		Sale entity = result.get();
		return new SaleMinDTO(entity);
	}	
	
	public Page<SaleReportDTO> reportSale(String minDate, String maxDate, String sellerName, Pageable pageable){
		LocalDate minDateAux;
		LocalDate maxDateAux;
		
		if(maxDate == null || maxDate == "") {
			maxDateAux = today;
		} else {
			maxDateAux = LocalDate.parse(maxDate);
		}
		
		if(minDate == null || minDate == "") {
			minDateAux = maxDateAux.minusYears(1L);
		} else {
			minDateAux = LocalDate.parse(minDate);
		}
		
		Page<Sale> result = repository.reportSale(minDateAux, maxDateAux, sellerName, pageable);
		return result.map(x -> new SaleReportDTO(x));		
	}
	
	public Page<SaleSumDTO> saleSum(Pageable pageable){
		Page<SaleSumProjection> page = repository.saleSum(pageable);
		Page<SaleSumDTO> result = page.map(x -> new SaleSumDTO(x));
		return result;
	}
	
}
