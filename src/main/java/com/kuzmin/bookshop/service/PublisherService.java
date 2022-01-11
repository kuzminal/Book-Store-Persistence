package com.kuzmin.bookshop.service;

import com.kuzmin.bookshop.entity.Publisher;
import com.kuzmin.bookshop.repository.PublisherRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublisherService {
    private final PublisherRepository publisherRepository;


    public PublisherService(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
        getAll();
    }

    List<Publisher> getAll() {
        return publisherRepository.findAll();
    }
}
