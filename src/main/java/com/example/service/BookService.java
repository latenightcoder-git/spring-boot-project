package com.example.service;

import com.example.entity.Book;

import java.util.List;

/**
 * Service Interface to handle business logic for Book Management.
 * This demonstrates an interface-driven architecture for loose coupling.
 */
public interface BookService {
    // Basic CRUD
    Book saveBook(Book book);
    List<Book> getAllBooks();
    Book getBookById(Long id);
    Book updateBook(Long id, Book bookDetails);
    void deleteBook(Long id);

    // Custom Search Methods
    Book getBookByTitle(String title);
    List<Book> getBooksByTitleKeyword(String keyword);
    List<Book> getBooksByAuthor(String author);

}
