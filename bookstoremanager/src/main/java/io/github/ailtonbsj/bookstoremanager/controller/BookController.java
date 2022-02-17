package io.github.ailtonbsj.bookstoremanager.controller;

import io.github.ailtonbsj.bookstoremanager.dto.BookDTO;
import io.github.ailtonbsj.bookstoremanager.dto.MessageResponseDTO;
import io.github.ailtonbsj.bookstoremanager.entity.Book;
import io.github.ailtonbsj.bookstoremanager.repository.BookRepository;
import io.github.ailtonbsj.bookstoremanager.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/books")
public class BookController {

    private BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    public MessageResponseDTO create(@RequestBody @Valid BookDTO bookDTO) {
        return bookService.create(bookDTO);
    }

    @GetMapping("/{id}")
    public BookDTO findById(@PathVariable Long id) {
        return bookService.findById(id);
    }
}
