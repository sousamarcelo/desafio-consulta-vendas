package com.devsuperior.dsmeta.repositories;


import java.time.LocalDate;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.devsuperior.dsmeta.entities.Sale;
import com.devsuperior.dsmeta.projections.SaleSumProjection;

public interface SaleRepository extends JpaRepository<Sale, Long> {
	
	//Consulta com JPQL
	@Query(value = "SELECT obj "
			+ "FROM Sale obj "
			+ "JOIN FETCH obj.seller "
			+ "WHERE obj.date >= :dateMin "
			+ "AND obj.date <= :dateMax "
			+ "AND UPPER(obj.seller.name) LIKE UPPER(CONCAT('%', :seller, '%')) ",
			countQuery = "SELECT COUNT(obj) FROM Sale obj JOIN obj.seller")
	Page<Sale> reportSale(LocalDate dateMin, LocalDate dateMax, String seller, Pageable pageable);	
	
	//Consulta com SQL	
	@Query(nativeQuery = true, value = "SELECT tb_seller.name, sum(tb_sales.amount) AS sum "
			+ "FROM tb_sales "
			+ "INNER JOIN tb_seller ON tb_sales.seller_id = tb_seller.id "
			+ "WHERE tb_sales.date BETWEEN :minDate AND :maxDate "
			+ "GROUP BY tb_seller.name")
	Page<SaleSumProjection> saleSum(LocalDate minDate, LocalDate maxDate,Pageable pageable);	
}
