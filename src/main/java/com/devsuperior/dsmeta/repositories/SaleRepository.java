package com.devsuperior.dsmeta.repositories;


import java.time.LocalDate;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.devsuperior.dsmeta.entities.Sale;

public interface SaleRepository extends JpaRepository<Sale, Long> {
	
	
	@Query(value = "SELECT obj "
			+ "FROM Sale obj "
			+ "JOIN FETCH obj.seller "
			+ "WHERE obj.date >= :dateMin "
			+ "AND obj.date <= :dateMax "
			+ "AND UPPER(obj.seller.name) LIKE UPPER(CONCAT('%', :seller, '%')) ",
			countQuery = "SELECT COUNT(obj) FROM Sale obj JOIN obj.seller")
	Page<Sale> reportSale(LocalDate dateMin, LocalDate dateMax, String seller, Pageable pageable);
	
}
