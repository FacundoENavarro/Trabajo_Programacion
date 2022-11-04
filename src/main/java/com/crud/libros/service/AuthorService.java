package com.crud.libros.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.libros.entity.Author;
import com.crud.libros.repository.AuthorRepository;

@Service
public class AuthorService {
    @Autowired
    AuthorRepository repository;

    public List<Author> findallAuthors() {
        return (List<Author>) repository.findAll();
    }

    public Author findAuthorById(int id) {
        Optional<Author> result = repository.findById(id);
        if (result.isPresent()) {
            return result.get();
        }
        return new Author();
    }

    public Author addAuthor(Author author) {
        return repository.save(author);
    }

    public Author updateAuthor(Author author) {
        Optional<Author> result = repository.findById(author.getId());
        Author existing = result.get();
        existing.setName(author.getName());
        return repository.save(existing);
    }

    public void deleteByIdd(int id) {
        repository.deleteById(id);
    }

}