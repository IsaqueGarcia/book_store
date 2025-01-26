package com.personal.bookstore.resource;

import com.personal.bookstore.dto.BookDTO;
import com.personal.bookstore.service.BookStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Optional;

@RestController()
@RequestMapping(value = "/v1/books")
public class BookStoreResource {

    @Autowired
    private BookStoreService service;


    @PostMapping
    private ResponseEntity<?> register(@RequestBody @Validated BookDTO book) {
        Integer id = service.register(book);
        return ResponseEntity.created(URI.create("v1/bookstore/" + id)).build();
    }

    @GetMapping(value = "/{id}")
    private ResponseEntity<?> consult(@PathVariable Integer id, @RequestParam(required = false) String title){
        Optional<BookDTO> response = service.consult(id, title);
        return ResponseEntity.ok(response.orElseGet(() -> new BookDTO.Builder("Nothing found").build()));
    }

}
