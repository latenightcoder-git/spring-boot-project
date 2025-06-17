package com.example.controller;

import com.example.entity.Book;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/api/books")
public class BookController {
    private final List<Book> books = new ArrayList<>();
    public BookController() {
        initializeBooks();
    }

    private void initializeBooks() {
        books.addAll(List.of(
                new Book("Crime and Punishment","Fyodor Dostoevsky","Existentialism"),
                new Book("Meditations","Marcus Aurelius","Stoicism"),
                new Book("The Republic","Plato","Political Philosophy"),
                new Book("Linux for Hackers","OccupyTheWeb","Cybersecurity"),
                new Book("The Web Application Hacker's Handbook","Dafydd Stuttard & Marcus Pinto","Web Security"),
                new Book("The Art of Exploitation","John Erickson","Hacking")
                ));
    }

    @GetMapping
    public List<Book> getBooks(@RequestParam(required = false) String category) {
        if (category == null) {
            return books;
        }
        return books.stream()
                .filter(book -> book.getCategory().equalsIgnoreCase(category))
                .toList();
    }

    @GetMapping("/{title}")
    public Book getBookByTitle(@PathVariable String title) {
        return books.stream()
                .filter(book -> book.getTitle().equalsIgnoreCase(title))
                .findFirst()
                .orElse(null);
    }

    @GetMapping("/booksall")
    public Stream<Book> getBooksStream() {
        return Stream.of(
                new Book("Crime and Punishment","Fyodor Dostoevsky","Existentialism"),
                new Book("Meditations","Marcus Aurelius","Stoicism"),
                new Book("The Republic","Plato","Political Philosophy"),
                new Book("Linux for Hackers","OccupyTheWeb","Cybersecurity"),
                new Book("The Web Application Hacker's Handbook","Dafydd Stuttard & Marcus Pinto","Web Security"),
                new Book("The Art of Exploitation","John Erickson","Hacking")
        );
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Book createBook(@RequestBody Book newBook) {
        boolean isNewBook = books.stream()
                .noneMatch(book -> book.getTitle().equalsIgnoreCase(newBook.getTitle()));
        if (isNewBook) {
            books.add(newBook);
        }
        return newBook;
    }

    @PutMapping("/{title}")
    public void updateBook(@PathVariable String title, @RequestBody Book updatedBook) {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getTitle().equalsIgnoreCase(title)) {
                books.set(i, updatedBook);
                return;
            }
        }
    }

    @DeleteMapping("/{title}")
    public void deleteBook(@PathVariable String title) {
        books.removeIf(book -> book.getTitle().equalsIgnoreCase(title));
    }
}

