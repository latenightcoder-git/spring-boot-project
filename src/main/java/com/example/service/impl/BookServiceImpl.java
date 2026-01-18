package com.example.service.impl;

import com.example.entity.Book;
import com.example.exception.BookNotFoundException;
import com.example.repository.BookRepository;
import com.example.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    @Override
    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book getBookById(Long id) {
        return bookRepository.findById(id).orElseThrow(()-> new BookNotFoundException("Book not found with ID: " + id));
    }

    @Override
    public Book updateBook(Long id, Book bookDetails) {
        Book existingBook = getBookById(id);
        existingBook.setTitle(bookDetails.getTitle());
        existingBook.setAuthor(bookDetails.getAuthor());
        existingBook.setIsbn(bookDetails.getIsbn());
        existingBook.setPrice(bookDetails.getPrice());
        existingBook.setPublishedDate(bookDetails.getPublishedDate());
        return bookRepository.save(existingBook);
    }

    @Override
    public void deleteBook(Long id) {
        Book book = getBookById(id);
        bookRepository.delete(book);
    }

    @Override
    public Book getBookByTitle(String title) {
        return bookRepository.findByTitle(title).orElseThrow(()-> new BookNotFoundException("No book found with title: " + title));
    }

    @Override
    public List<Book> getBooksByTitleKeyword(String keyword) {
        return bookRepository.findByTitleContainingIgnoreCase(keyword);
    }

    @Override
    public List<Book> getBooksByAuthor(String author) {
        List<Book> books = bookRepository.findByAuthorIgnoreCase(author);
        if (books.isEmpty()){
            throw new RuntimeException("No books found by author: " + author);
        }
        return books;
    }
}
