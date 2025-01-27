package com.personal.bookstore.service.impl;

import com.personal.bookstore.dto.BookDTO;
import com.personal.bookstore.repository.BookStoreRepository;
import com.personal.bookstore.service.BookStoreService;
import io.micrometer.common.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.Optional;

@Service
public class BookStoreServiceImpl implements BookStoreService {

    @Autowired
    BookStoreRepository repository;

    @Override
    public String register(BookDTO request) {
        BookDTO response = repository.save(request);
        return response.getTitle();
    }

    @Override
    public Optional<BookDTO> consult(String title) {

        Optional<BookDTO> book = Optional.empty();

        if(StringUtils.isEmpty(title)){
            throw new RuntimeException("The title can't be null or empty");
        }

        book = repository.findByTitle(title);

        return book;
    }
}
