package com.example.Spring_GraphQL_Workshop.respository;

import com.example.Spring_GraphQL_Workshop.model.Book;
import com.example.Spring_GraphQL_Workshop.model.Rating;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Repository
public class BookRepository {

    private final AuthorRepository authorRepository;

    private List<Book> books = new ArrayList<>();

    public BookRepository(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public List<Book> getAllBooks() {
        return books;
    }

    public Book getBookById(Integer id) {
        return books.stream()
                .filter(book -> Objects.equals(book.id(), id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Book not found"));
    }

    public Book getBookByTitle(String title) {
        return books.stream()
                .filter(book -> Objects.equals(book.title(), title))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Book not found"));
    }

    public List<Book> getBookByCategory(String category) {
        return books.stream()
                .filter(book -> Objects.equals(book.category(), category))
                .collect(Collectors.toList());
    }

    @PostConstruct
    private void init() {
        books.add(new Book(1,
                "Spring Reactive",
                Rating.FIVE_STARS,
                authorRepository.getAuthorByFullName("John Doe")
                ,"A"
                ,new BigDecimal(200)
                ,OffsetDateTime.now()));
        books.add(new Book(2,
                "How to get high salary",
                Rating.ONE_STAR,
                authorRepository.getAuthorByFullName("Jane Doe")
                ,"B"
                ,new BigDecimal(250)
                ,OffsetDateTime.now()));
        books.add(new Book(3,
                "Docker 101",
                Rating.THREE_STARS,
                authorRepository.getAuthorByFullName("Jack Doe")
                ,"A"
                ,new BigDecimal(300)
                ,OffsetDateTime.now()));
    }
}
