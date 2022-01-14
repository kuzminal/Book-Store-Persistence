package com.kuzmin.bookshop.service;

import com.kuzmin.bookshop.entity.Book;
import com.kuzmin.bookshop.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookstoreService {
    private final BookRepository bookRepository;

    public BookstoreService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
        getAll();
    }

    public List<Book> getAll() {
        return bookRepository.findAll();
    }
}
