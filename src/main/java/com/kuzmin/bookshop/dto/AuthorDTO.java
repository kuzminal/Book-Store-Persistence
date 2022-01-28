package com.kuzmin.bookshop.dto;

import java.io.Serializable;
import java.util.Objects;

public class AuthorDTO implements Serializable {
    private Long id;
    private String name;
    private String genre;
    private int age;

    public AuthorDTO(Long id, String name, String genre, int age) {
        this.id = id;
        this.name = name;
        this.genre = genre;
        this.age = age;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AuthorDTO authorDTO = (AuthorDTO) o;
        return age == authorDTO.age && Objects.equals(id, authorDTO.id) && Objects.equals(name, authorDTO.name) && Objects.equals(genre, authorDTO.genre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, genre, age);
    }
}
