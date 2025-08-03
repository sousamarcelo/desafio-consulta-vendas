package com.devsuperior.dsmeta;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.devsuperior.dsmeta.dto.SaleReportDTO;
import com.devsuperior.dsmeta.entities.Sale;
import com.devsuperior.dsmeta.repositories.SaleRepository;

@SpringBootApplication
public class DsmetaApplication implements CommandLineRunner {

	@Autowired
	SaleRepository repository;
		
	public static void main(String[] args) {
		SpringApplication.run(DsmetaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		/*
		Page<Sale> list = repository.reportSale(LocalDate.parse("2022-05-01"),LocalDate.parse("2022-05-31"), "odinson");
		
		List<SaleReportDTO> result1 = list.stream().map(x -> new SaleReportDTO(x)).collect(Collectors.toList());
		
		for(SaleReportDTO obj : result1) {
			System.out.println(obj);
		}
		*/
		
	}
}
