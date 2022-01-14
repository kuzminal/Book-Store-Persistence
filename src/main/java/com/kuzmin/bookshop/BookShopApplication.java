package com.kuzmin.bookshop;

import com.kuzmin.bookshop.service.BookstoreService;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BookShopApplication {
    private final BookstoreService bookstoreService;

    public BookShopApplication(BookstoreService bookstoreService) {
        this.bookstoreService = bookstoreService;
    }

    public static void main(String[] args) {
        SpringApplication.run(BookShopApplication.class, args);
    }

    @Bean
    public ApplicationRunner init() {
        return args -> {
            System.out.println("\nInsert author with books  ...");
            bookstoreService.newBookOfAuthor();
            System.out.println("\nFetch Book By AuthorId  ...");
            bookstoreService.fetchBookByAuthorId();
        };
    }
}
