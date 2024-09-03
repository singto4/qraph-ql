package com.example.Spring_GraphQL_Workshop.respository;

import com.example.Spring_GraphQL_Workshop.model.Author;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class AuthorRepository {

    private List<Author> authors = new ArrayList<>();

    public List<Author> getAuthors() {
        return authors;
    }

    public Author getAuthorById(Integer id) {
        return authors.stream()
                .filter(author -> Objects.equals(author.id(), id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Author not found"));
    }

    public Author getAuthorByFullName(String fullName) {
        return authors.stream()
                .filter(author -> author.getFullName().equals(fullName))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Author not found"));
    }

    @PostConstruct
    private void init(){
        authors.add(new Author(1, "John", "Doe"));
        authors.add(new Author(2, "Jane", "Doe"));
        authors.add(new Author(3, "Jack", "Doe"));
    }
}
