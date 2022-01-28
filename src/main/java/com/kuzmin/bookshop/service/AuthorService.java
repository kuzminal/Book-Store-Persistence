package com.kuzmin.bookshop.service;

import com.kuzmin.bookshop.dto.AuthorDTO;
import com.kuzmin.bookshop.entity.Author;
import com.kuzmin.bookshop.repository.AuthorRepository;
import com.kuzmin.bookshop.repository.AuthorSpecs;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {
    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
        getAll();
    }

    public List<Author> getAll() {
        return authorRepository.findAll(AuthorSpecs.isAgeGt45());
    }

    public AuthorDTO getByName(String name) {
        return authorRepository.fetchByNameWithoutBooks(name);
    }
}
