package com.personal.bookstore.repository;

import com.personal.bookstore.dto.BookDTO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookStoreRepository extends CrudRepository<BookDTO, Integer> {

    Optional<BookDTO> findByTitle(String title);

}
