package io.javabrains.betterreaderapp.author;

import io.javabrains.betterreaderapp.user.BooksByUser;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorBooksRepository extends CassandraRepository<AuthorBooks, String> {
    Slice<AuthorBooks> findAllById(String id, Pageable pageable);

}
