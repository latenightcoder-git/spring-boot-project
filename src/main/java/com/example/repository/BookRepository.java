package com.example.repository;

import com.example.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


public interface BookRepository extends JpaRepository<Book,Long> {

    // Spring will automatically generate: SELECT * FROM BOOKS WHERE TITLE = ?
    Optional<Book> findByTitle(String title);

    // Optional: Search for books that contain a certain word (like search bar)
    List<Book> findByTitleContainingIgnoreCase(String title);

    // Custom finder method to filter by author
    List<Book> findByAuthor(String author);

    // Optional: Case-insensitive search (useful for user-friendly APIs)
    List<Book> findByAuthorIgnoreCase(String author);
}
