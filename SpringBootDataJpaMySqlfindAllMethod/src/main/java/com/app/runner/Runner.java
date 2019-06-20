package com.app.runner;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Component;

import com.app.model.Product;
import com.app.repo.ProductRepo;
@Component
public class Runner implements CommandLineRunner {

	@Autowired
	private ProductRepo repo;
	@Override
	public void run(String... args) throws Exception {
		
		/*
		 * List<Product> lst =repo.findAll(); lst.forEach(System.out::println);
		 * 
		 * repo.findAll(Sort.by(Direction.DESC,"prodCode")).forEach(System.out::println)
		 * ; repo.findAll(Sort.by("prodCode")).forEach(System.out::println);
		 * 
		 * PageRequest p = PageRequest.of(1,3);
		 * repo.findAll(p).forEach(System.out::println);
		 */
	
		Product p2 = new Product();
		p2.setProdCost(2.3);
		Example ex = Example.of(p2);
		repo.findAll(ex).forEach(System.out::println);
		
		
		
		Product p3 = new Product();
		p3.setProdCost(2.3);
		Example ex2 = Example.of(p3);
		repo.findAll(ex,Sort.by(Direction.DESC,"prodCode")).forEach(System.out::println);
		
		Product p4 = new Product();
		p4.setProdCost(2.3);
		Example ex3 = Example.of(p4);
		repo.findAll(ex3,PageRequest.of(1,1)).forEach(System.out::println);
		
		
		repo.findAllById(Arrays.asList(11,12,13,14,15)).forEach(System.out::println);
	}

}
