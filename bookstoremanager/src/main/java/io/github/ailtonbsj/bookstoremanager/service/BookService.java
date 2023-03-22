package io.github.ailtonbsj.bookstoremanager.service;

import io.github.ailtonbsj.bookstoremanager.dto.BookDTO;
import io.github.ailtonbsj.bookstoremanager.dto.MessageResponseDTO;
import io.github.ailtonbsj.bookstoremanager.entity.Book;
import io.github.ailtonbsj.bookstoremanager.exception.BookNotFoundException;
import io.github.ailtonbsj.bookstoremanager.mapper.BookMapper;
import io.github.ailtonbsj.bookstoremanager.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    private BookRepository bookRepository;
    private final BookMapper bookMapper = BookMapper.INSTANCE;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public MessageResponseDTO create(BookDTO bookDTO) {
        Book book = bookMapper.toModel(bookDTO);
        Book savedBook = bookRepository.save(book);
        return MessageResponseDTO.builder()
                .message("Book created with ID " + savedBook.getId()).build();
    }

    public BookDTO findById(Long id) throws BookNotFoundException {
        Book book = bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException(id));
        return bookMapper.toDTO(book);
    }
}
