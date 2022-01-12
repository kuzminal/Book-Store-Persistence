package com.kuzmin.bookshop.service;

import com.kuzmin.bookshop.entity.Author;
import com.kuzmin.bookshop.entity.Book;
import com.kuzmin.bookshop.repository.AuthorRepository;
import com.kuzmin.bookshop.repository.AuthorSpecs;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AuthorService {
    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public List<Author> getAll() {
        return authorRepository.findAll();
    }

    @Transactional(readOnly = true)
    public void fetchAuthorWithAllBooks() {
        Author author = authorRepository.findById(1L).orElseThrow();
        List<Book> books = author.getBooks();
        System.out.println(books);
    }
    @Transactional(readOnly = true)
    public void fetchAuthorWithCheapBooks() {
        Author author = authorRepository.findById(1L).orElseThrow();
        List<Book> books = author.getCheapBooks();
        System.out.println(books);
    }
    @Transactional(readOnly = true)
    public void fetchAuthorWithRestOfBooks() {
        Author author = authorRepository.findById(1L).orElseThrow();
        List<Book> books = author.getRestOfBooks();
        System.out.println(books);
    }
}
