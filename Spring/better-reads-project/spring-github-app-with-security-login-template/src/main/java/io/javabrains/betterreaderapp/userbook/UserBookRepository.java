package io.javabrains.betterreaderapp.userbook;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserBookRepository extends CassandraRepository<UserBook, UserBooksPrimaryKey> {
}
