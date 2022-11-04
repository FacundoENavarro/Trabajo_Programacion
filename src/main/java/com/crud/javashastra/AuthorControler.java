package com.crud.javashastra;

import com.crud.javashastra.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.crud.javashastra.entity.Author;
import com.crud.javashastra.service.AuthorService;

public class AuthorControler {


    @Autowired
    AuthorService service;

    @GetMapping("/")
    public String findAll(Model model) {
        model.addAttribute("authors", service.findallAuthors());
        return "all-authors";
    }

    @GetMapping("/add")
    public String lunchAddAuthorPage(Model model) {
        model.addAttribute("author", new Author());
        return "add-author";
    }

    @PostMapping("/addauthor")
    public String createAuthor(Author author) {
        service.addAuthor(author);
        return "redirect:/";

    }

    @GetMapping("/edit/{id}")
    public String lunchEditPage(Model model, @PathVariable("id") int id) {
        model.addAttribute("author", service.findAuthorById(id));
        return "edit-author";

    }

    @PostMapping("/updateAuthor")
    public String updateAuthor(Author author) {
        service.updateAuthor(author);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteAuthor(@PathVariable("id") int id) {
        service.deleteByIdd(id);
        return "redirect:/";
    }

    @GetMapping("/test")
    public String test() {
        Author st = new Author();
        st.setId(1);
        st.setName("Java");
        service.addAuthor(st);
        return "index";

    }



}
