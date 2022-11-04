package com.crud.libros.repository;

import org.springframework.data.repository.CrudRepository;

import com.crud.libros.entity.Author;

public interface AuthorRepository extends CrudRepository<Author, Integer> {

}

