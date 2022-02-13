package com.cg.betterreadsdataloader.author;

import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.*;
import org.springframework.data.cassandra.core.mapping.CassandraType.*;

import java.time.LocalDate;


@Table(value = "books_by_author")
public class AuthorBooks {
    @PrimaryKeyColumn(name="author_id", ordinal = 0, type = PrimaryKeyType.PARTITIONED)
    private String authorId;
    @Column(value = "book_title")
    @CassandraType(type = Name.TEXT)
    private String bookTitle;
    @Column(value = "published_date")
    @CassandraType(type = Name.DATE)
    private LocalDate publishedDate;

    public String getAuthorId() {
        return authorId;
    }

    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public LocalDate getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(LocalDate publishedDate) {
        this.publishedDate = publishedDate;
    }
}
