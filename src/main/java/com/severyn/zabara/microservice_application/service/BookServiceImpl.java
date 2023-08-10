package com.severyn.zabara.microservice_application.service;


import com.severyn.zabara.microservice_application.BookRepository;
import com.severyn.zabara.microservice_application.entity.BookEntity;
import com.severyn.zabara.microservice_application.exception.BookNotFoundException;
import com.severyn.zabara.microservice_application.model.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;


    @Override
    public Book getBookById(Long id) throws BookNotFoundException {
        BookEntity bookEntity = bookRepository
                .findById(id)
                .orElseThrow(() -> new BookNotFoundException("book not found : id = " + id));
        return new Book(bookEntity.getId(),
                bookEntity.getAuthor(),
                bookEntity.getTitle(),
                bookEntity.getPrice());
    }

    @Override
    public List<Book> getBooks() {
        return StreamSupport.stream(bookRepository.findAll().spliterator(), false).map(bookEntity -> new Book(bookEntity.getId(),
                bookEntity.getAuthor(),
                bookEntity.getTitle(),
                bookEntity.getPrice())).toList();
    }

    @Override
    public void addBook(Book book) {
        BookEntity bookEntity = new BookEntity(book.getId(),
                                    book.getAuthor(),
                                    book.getTitle(),
                                    book.getPrice());
        bookRepository.save(bookEntity);
    }


}
