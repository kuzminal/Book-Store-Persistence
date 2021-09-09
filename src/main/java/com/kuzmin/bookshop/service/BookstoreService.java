package com.kuzmin.bookshop.service;

import com.kuzmin.bookshop.entity.Author;
import com.kuzmin.bookshop.entity.Book;
import com.kuzmin.bookshop.repository.AuthorRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookstoreService {

    private final AuthorRepository authorRepository;

    public BookstoreService(AuthorRepository authorRepository) {

        this.authorRepository = authorRepository;
        insertAuthorWithBooks();
    }

    @Transactional
    public void insertAuthorWithBooks() {
        Author jn = new Author();
        jn.setName("Joana Nimar");
        jn.setAge(34);
        jn.setGenre("History");
        Book jn01 = new Book();
        jn01.setIsbn("001-JN");
        jn01.setTitle("A History of Ancient Prague");
        Book jn02 = new Book();
        jn02.setIsbn("002-JN");
        jn02.setTitle("A People's History");
        Book jn03 = new Book();
        jn03.setIsbn("003-JN");
        jn03.setTitle("World History");
        jn.addBook(jn01);
        jn.addBook(jn02);
        jn.addBook(jn03);
        authorRepository.save(jn);

        Author author = new Author();
        author.setName("Alicia Tom");
        author.setAge(38);
        author.setGenre("Anthology");

        Book book = new Book();
        book.setIsbn("001-AT");
        book.setTitle("The book of swords");

        author.addBook(book); // use addBook() helper

        authorRepository.save(author);
    }
}
