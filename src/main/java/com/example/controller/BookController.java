package com.example.controller;

import com.example.entity.Book;
import com.example.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
@AllArgsConstructor
public class BookController {

    private final BookService bookService;

    // 1. Create a New Book
    @PostMapping("/books")
    public ResponseEntity<Book> createBook(@RequestBody Book book) {
        return new ResponseEntity<>(bookService.saveBook(book), HttpStatus.CREATED);
    }

    // 2. Get All Books
    @GetMapping("/books")
    public ResponseEntity<List<Book>> getAllBooks() {
        return ResponseEntity.ok(bookService.getAllBooks());
    }

    // 3. Get Book by ID
    @GetMapping("/books/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id) {
        return ResponseEntity.ok(bookService.getBookById(id));
    }

    // 4. Update Book
    @PutMapping("/books/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable Long id, @RequestBody Book bookDetails) {
        return ResponseEntity.ok(bookService.updateBook(id, bookDetails));
    }

    // 5. Delete Book
    @DeleteMapping("/books/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
        return ResponseEntity.ok("Book with ID " + id + " has been deleted successfully.");
    }

    // 6. Search by Title (Exact)
    @GetMapping("/books/search/title")
    public ResponseEntity<Book> getBookByTitle(@RequestParam String name) {
        return ResponseEntity.ok(bookService.getBookByTitle(name));
    }

    // 7. Search by Title Keyword (Like search bar)
    @GetMapping("/books/search/keyword")
    public ResponseEntity<List<Book>> searchByKeyword(@RequestParam String key) {
        return ResponseEntity.ok(bookService.getBooksByTitleKeyword(key));
    }

    // 8. Search by Author
    @GetMapping("/books/search/author")
    public ResponseEntity<List<Book>> getBooksByAuthor(@RequestParam String name) {
        return ResponseEntity.ok(bookService.getBooksByAuthor(name));
    }
}