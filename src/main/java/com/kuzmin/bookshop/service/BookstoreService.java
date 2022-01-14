package com.kuzmin.bookshop.service;

import com.kuzmin.bookshop.entity.Author;
import com.kuzmin.bookshop.entity.Book;
import com.kuzmin.bookshop.repository.AuthorRepository;
import com.kuzmin.bookshop.repository.BookRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BookstoreService {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BookstoreService(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    List<Book> getAll() {
        return bookRepository.findAll();
    }

    @Transactional
    public void newBookOfAuthor() {
        Author author = authorRepository.findById(1L).orElseThrow();
        Book book = new Book();
        book.setTitle("A History of Ancient Prague");
        book.setIsbn("001-JN");
// this will set the id of the book as the id of the author
        book.setAuthor(author);
        bookRepository.save(book);
    }

    @Transactional(readOnly = true)
    public Book fetchBookByAuthorId() {
        Author author = authorRepository.findById(1L).orElseThrow();
        return bookRepository.findById(author.getId()).orElseThrow();
    }
}
