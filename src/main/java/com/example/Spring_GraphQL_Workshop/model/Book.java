package com.example.Spring_GraphQL_Workshop.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

public record Book(Integer id, String title, Rating rating, Author author, String category, BigDecimal price, OffsetDateTime createDate) {

}
