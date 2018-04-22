package com.example.springbootgraphQL.services.dataFetcher;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.springbootgraphQL.model.Book;
import com.example.springbootgraphQL.repository.BookRepository;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;

@Component
public class BookdataFetcher implements  DataFetcher<Book>{

	
	@Autowired
	BookRepository bookRepo;
	
	@Override
	public Book get(DataFetchingEnvironment arg0) {
		// TODO Auto-generated method stub
	Iterable<String> isn=	arg0.getArgument("id");
		return (Book) bookRepo.findAllById(isn);
	}

}
