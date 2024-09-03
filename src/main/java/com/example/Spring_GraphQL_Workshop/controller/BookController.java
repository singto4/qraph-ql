package com.example.Spring_GraphQL_Workshop.controller;

import com.example.Spring_GraphQL_Workshop.model.Book;
import com.example.Spring_GraphQL_Workshop.respository.BookRepository;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class BookController {

    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @QueryMapping
    public List<Book> allBooks() {
        return bookRepository.getAllBooks();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @QueryMapping
    public Book findBookById(@Argument Integer id) {
        return bookRepository.getBookById(id);
    }

    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    @QueryMapping
    public Book findBookByTitle(@Argument String title) {
        return bookRepository.getBookByTitle(title);
    }

    @PreAuthorize("hasRole('USER')")
    @QueryMapping
    public List<Book> findBookByCategory(@Argument String category) {
        return bookRepository.getBookByCategory(category);
    }

}
