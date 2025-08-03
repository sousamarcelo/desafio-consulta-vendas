package com.devsuperior.dsmeta.services;


import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.devsuperior.dsmeta.dto.SaleMinDTO;
import com.devsuperior.dsmeta.dto.SaleReportDTO;
import com.devsuperior.dsmeta.entities.Sale;
import com.devsuperior.dsmeta.repositories.SaleRepository;

@Service
public class SaleService {

	@Autowired
	private SaleRepository repository;
	
	public SaleMinDTO findById(Long id) {
		Optional<Sale> result = repository.findById(id);
		Sale entity = result.get();
		return new SaleMinDTO(entity);
	}	
	
	public Page<SaleReportDTO> reportSale(String minDate, String maxDate, String sellerName, Pageable pageable){
		Page<Sale> result = repository.reportSale(LocalDate.parse(minDate), LocalDate.parse(maxDate), sellerName, pageable);
		return result.map(x -> new SaleReportDTO(x));		
	}
	
}
