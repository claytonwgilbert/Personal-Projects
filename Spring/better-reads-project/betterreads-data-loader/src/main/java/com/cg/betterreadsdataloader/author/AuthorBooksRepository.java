package com.cg.betterreadsdataloader.author;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorBooksRepository extends CassandraRepository<AuthorBooks, String> {
}
