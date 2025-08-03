package com.devsuperior.dsmeta.repositories;


import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.devsuperior.dsmeta.entities.Sale;

public interface SaleRepository extends JpaRepository<Sale, Long> {
	
	
	@Query("SELECT obj "
			+ "FROM Sale obj "
			+ "JOIN FETCH obj.seller "
			+ "WHERE obj.date >= :dateMin "
			+ "AND obj.date <= :dateMax "
			+ "AND UPPER(obj.seller.name) LIKE UPPER(CONCAT('%', :seller, '%'))"
			)
	List<Sale> reportSale(LocalDate dateMin, LocalDate dateMax, String seller);
	
}
