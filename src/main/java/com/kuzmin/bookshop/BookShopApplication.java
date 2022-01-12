package com.kuzmin.bookshop;

import com.kuzmin.bookshop.service.AuthorService;
import com.kuzmin.bookshop.service.BookstoreService;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BookShopApplication {
    private final AuthorService authorService;

    public BookShopApplication(AuthorService authorService) {
        this.authorService = authorService;
    }

    public static void main(String[] args) {
        SpringApplication.run(BookShopApplication.class, args);
    }

    @Bean
    public ApplicationRunner init() {
        return args -> {
            System.out.println("\nAuthor with all books ...");
            authorService.fetchAuthorWithAllBooks();

            System.out.println("\nAuthor with cheap books ...");
            authorService.fetchAuthorWithCheapBooks();

            System.out.println("\nAuthor with rest of books ...");
            authorService.fetchAuthorWithRestOfBooks();
        };
    }

}
