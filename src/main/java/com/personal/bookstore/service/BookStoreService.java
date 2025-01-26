package com.personal.bookstore.service;

import com.personal.bookstore.dto.BookDTO;

import java.util.Optional;

public interface BookStoreService {

    Integer register(BookDTO request);
    Optional<BookDTO> consult(Integer id, String... title);

}
