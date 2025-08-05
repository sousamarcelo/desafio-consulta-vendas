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
				
		LocalDate maxDateAux = convertMaxDate(maxDate);
		LocalDate minDateAux = convertMinDate(minDate, convertMaxDate(maxDate));
		
		Page<Sale> result = repository.reportSale(minDateAux, maxDateAux, sellerName, pageable);
		return result.map(x -> new SaleReportDTO(x));		
	}
		
	public Page<SaleSumDTO> saleSum(String minDate, String maxDate,Pageable pageable){
				
		LocalDate maxDateAux = convertMaxDate(maxDate);
		LocalDate minDateAux = convertMinDate(minDate, convertMaxDate(maxDate));				
				
		Page<SaleSumProjection> page = repository.saleSum(minDateAux, maxDateAux, pageable);				
		return page.map(x -> new SaleSumDTO(x));
	}
		
	private LocalDate convertMinDate(String minDate, LocalDate maxDateAux) {		
		LocalDate minDateAux;			
		
		if(minDate == null || minDate == "") {			
			minDateAux = maxDateAux.minusYears(1L);
		} else {
			minDateAux = LocalDate.parse(minDate);
		}
				
		return minDateAux;		
	}
	
	private LocalDate convertMaxDate(String maxDate) {		
		LocalDate maxDateAux;			
		
		if(maxDate == null || maxDate == "") {
			maxDateAux = today;
		} else {
			maxDateAux = LocalDate.parse(maxDate);
		}
				
		return maxDateAux;		
	}	
}
