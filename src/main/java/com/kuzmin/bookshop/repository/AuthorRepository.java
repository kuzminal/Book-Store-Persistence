package com.kuzmin.bookshop.repository;

import com.kuzmin.bookshop.entity.Author;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional(readOnly = true)
public interface AuthorRepository extends JpaRepository<Author, Long>, JpaSpecificationExecutor<Author> {

    @Override
    @EntityGraph(attributePaths = {"books.publisher"},
            type = EntityGraph.EntityGraphType.FETCH)
    List<Author> findAll();

    @Query("SELECT a FROM Author a JOIN FETCH a.books WHERE a.name = ?1")
    Author fetchByName(String name);

    @EntityGraph(value = "author-books-graph",
            type = EntityGraph.EntityGraphType.FETCH)
    List<Author> findByAgeGreaterThanAndGenre(int age, String genre);

    @EntityGraph(value = "author-books-graph",
            type = EntityGraph.EntityGraphType.LOAD)
    List<Author> findByGenreAndAgeGreaterThan(String genre, int age);
}
