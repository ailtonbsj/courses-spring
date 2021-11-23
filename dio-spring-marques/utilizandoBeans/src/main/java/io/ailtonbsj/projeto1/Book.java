package io.ailtonbsj.projeto1;

import org.springframework.beans.factory.annotation.Autowired;

public class Book {
	private String name;
	private String id;
	@Autowired
	private AuthorBook authorBook;
	
	public Book() {
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public AuthorBook getAuthorBook() {
		return authorBook;
	}
	public void setAuthorBook(AuthorBook authorBook) {
		this.authorBook = authorBook;
	}

	@Override
	public String toString() {
		return "Book [name=" + name + ", id=" + id + "]";
	}
	public void show() {
		System.out.println(this.toString());
		authorBook.showAuthor();
	}
}
