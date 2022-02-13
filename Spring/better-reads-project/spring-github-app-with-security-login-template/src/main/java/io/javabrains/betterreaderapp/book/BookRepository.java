package io.javabrains.betterreaderapp.book;

import org.springframework.data.cassandra.repository.CassandraRepository;

import java.util.List;

public interface BookRepository extends CassandraRepository<Book, String> {
    List<Book> findAllByAuthorNamesLike(List<String> authorNames);
}
