package com.kuzmin.bookshop;

import com.kuzmin.bookshop.service.AuthorService;
import com.kuzmin.bookshop.service.BookstoreService;
import com.kuzmin.bookshop.service.PublisherService;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BookShopApplication {
    private final BookstoreService bookstoreService;
    private final AuthorService authorService;
    private final PublisherService publisherService;

    public BookShopApplication(BookstoreService bookstoreService, AuthorService authorService, PublisherService publisherService) {
        this.bookstoreService = bookstoreService;
        this.authorService = authorService;
        this.publisherService = publisherService;
    }

    public static void main(String[] args) {
        SpringApplication.run(BookShopApplication.class, args);
    }

    @Bean
    public ApplicationRunner init() {
        return args -> {
            System.out.println("\nFind all books  ...");
            bookstoreService.getAll();
            System.out.println("\nFind all authors  ...");
            authorService.getAll();
            System.out.println("\nFind all publishers  ...");
            publisherService.getAll();
        };
    }
}
