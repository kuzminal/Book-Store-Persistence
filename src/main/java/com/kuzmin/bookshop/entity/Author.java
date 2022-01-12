package com.kuzmin.bookshop.entity;

import org.hibernate.annotations.Where;

import java.io.Serializable;
import java.util.*;
import javax.persistence.*;

@Entity
public class Author implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String genre;
    private int age;

    @OneToMany(cascade = CascadeType.ALL,
            mappedBy = "author", orphanRemoval = true)
    private List<Book> books = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL,
            mappedBy = "author", orphanRemoval = true)
    @Where(clause = "price <= 20")
    private List<Book> cheapBooks = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL,
            mappedBy = "author", orphanRemoval = true)
    @Where(clause = "price > 20")
    private List<Book> restOfBooks = new ArrayList<>();

    public List<Book> getCheapBooks() {
        return cheapBooks;
    }

    public void setCheapBooks(List<Book> cheapBooks) {
        this.cheapBooks = cheapBooks;
    }

    public List<Book> getRestOfBooks() {
        return restOfBooks;
    }

    public void setRestOfBooks(List<Book> restOfBooks) {
        this.restOfBooks = restOfBooks;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }  

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "Author{" + "id=" + id + ", name=" + name 
                + ", genre=" + genre + ", age=" + age + '}';
    }
    
}
