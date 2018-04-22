package com.example.springbootgraphQL.services;

import java.io.File;
import java.io.IOException;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import com.example.springbootgraphQL.model.Book;
import com.example.springbootgraphQL.repository.BookRepository;
import com.example.springbootgraphQL.services.dataFetcher.AllBooksdataFetcher;
import com.example.springbootgraphQL.services.dataFetcher.BookdataFetcher;

import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;

@Service
public class GraphQLService {

	@Value("classpath:books.graphql")
	Resource resource;
	
	@Autowired
	BookRepository BookRepo;
	
	private GraphQL graphQL;
	@Autowired
	private AllBooksdataFetcher allBooksdataFetcher;
	@Autowired
	private BookdataFetcher bookdataFetcher;

	
	@PostConstruct
	private void loadSchema() throws Exception
	{
		
		loadDataIntoHSQL();
		
	File schemaFile = resource.getFile();
	TypeDefinitionRegistry typeRegistry= new SchemaParser().parse(schemaFile);
	RuntimeWiring wiring= buildRuntimeWiring();
	
	GraphQLSchema schema = new SchemaGenerator().makeExecutableSchema(typeRegistry, wiring);
	graphQL= GraphQL.newGraphQL(schema).build();
	}

	private void loadDataIntoHSQL() {
		// TODO Auto-generated method stub
	Stream.of(
			new Book("123","Book Of Cloud","Kindle Edition", new String[] {"Chole Go"},"12 Nov 2018")
			).forEach(
			book -> {BookRepo.save(book);}
			);	
	}

	private RuntimeWiring buildRuntimeWiring() {
		// TODO Auto-generated method stub
		return RuntimeWiring.newRuntimeWiring()
				.type("Query", typeWiring -> 
					typeWiring.
					dataFetcher("allBooks", allBooksdataFetcher).
					dataFetcher("book", bookdataFetcher))
				.build();
	}
	
	
	public GraphQL getGraphQL() 
	{
		return graphQL; 
	}
}
