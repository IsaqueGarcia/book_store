package com.personal.bookstore.repository;

import com.personal.bookstore.dto.BookDTO;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface BookStoreRepository extends MongoRepository<BookDTO, String> {

    Optional<BookDTO> findByTitle(String title);

}
