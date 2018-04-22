package com.example.springbootgraphQL.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springbootgraphQL.model.Book;

public interface BookRepository extends JpaRepository<Book, String> {

}
