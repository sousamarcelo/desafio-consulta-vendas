package com.devsuperior.dsmeta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
		/* testes
		List<SaleSumProjection> list = repository.saleSum(LocalDate.parse("2022-01-01"),LocalDate.parse("2022-06-30"));		
		List<SaleSumDTO> result1 = list.stream().map(x -> new SaleSumDTO(x)).collect(Collectors.toList());
		
		for(SaleSumDTO obj : result1) {
			System.out.println(obj);
		}
		*/
		
		
	}
}
