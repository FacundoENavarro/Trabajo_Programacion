package com.crud.libros.repository;

import org.springframework.data.repository.CrudRepository;

import com.crud.libros.entity.Book;

public interface BookRepository extends CrudRepository<Book, Integer> {

}
