package com.example.springbootgraphQL.services.dataFetcher;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.springbootgraphQL.model.Book;
import com.example.springbootgraphQL.repository.BookRepository;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;

@Component
public class AllBooksdataFetcher implements  DataFetcher<List<Book>>{

	@Autowired
	BookRepository bookRepo;
	
	@Override
	public List<Book> get(DataFetchingEnvironment arg0) {
		// TODO Auto-generated method stub
		return bookRepo.findAll();
	}



}
