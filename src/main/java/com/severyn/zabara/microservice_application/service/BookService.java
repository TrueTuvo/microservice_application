package com.severyn.zabara.microservice_application.service;

import com.severyn.zabara.microservice_application.exception.BookNotFoundException;
import com.severyn.zabara.microservice_application.model.Book;

import java.util.List;

public interface BookService {

    Book getBookById(Long id) throws BookNotFoundException;

    List<Book> getBooks();

    void addBook(Book book);


}
