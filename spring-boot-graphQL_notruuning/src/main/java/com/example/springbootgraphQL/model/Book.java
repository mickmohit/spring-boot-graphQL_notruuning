package com.example.springbootgraphQL.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/*LomBok*/

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor


@Table
@Entity
public class Book {

	
	public Book(String string, String string2, String string3, String[] strings, String string4) {
		// TODO Auto-generated constructor stub
	}
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public String isn;
	public String title;
	public String publisher;
	public String[] authors;
	public String publishedDate;
	
}
