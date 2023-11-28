package com.example.notes;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller //anot,springes,utvonalak,
public class BookController {
    private final BookRepository repository;

    public BookController(BookRepository repository) {
        this.repository = repository;
    }
//metods htttp kéréssel
    @GetMapping("/books")
    public String getBooks(Model model) {
        model.addAttribute("books", repository.findAll());
        return "books"; // Thymeleaf template
    }

    @GetMapping("/addBook")
    public String addBookForm(Model model) {
        model.addAttribute("book", new Book());
        return "addBook"; // Thymeleaf template for adding book
    }

    @PostMapping("/addBook")
    public String saveBook(@ModelAttribute Book book) {
        repository.save(book);
        return "redirect:/books";
    }

    @GetMapping("/deleteBook/{id}")
    public String deleteBook(@PathVariable("id") long id) {
        repository.deleteById(id);
        return "redirect:/books";
    }
}
