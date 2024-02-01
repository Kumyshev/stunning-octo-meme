package com.example.octomeme.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.octomeme.model.Comix;
import com.example.octomeme.rep.ComixRepository;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/api/comixies")
public class ComixController {
    @Autowired
    private ComixRepository repository;

    @GetMapping
    public Iterable<Comix> getAll() {
        return repository.findAll();
    }

    @GetMapping("/author/{comixAuthor}")
    public List<Comix> getMethodName(@RequestParam String author) {
        return repository.findByAuthor(author);
    }

    @GetMapping("/{id}")
    public Comix getComix(@RequestParam Long id) {
        return repository.findById(id).orElseThrow(RuntimeException::new);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Comix create(@RequestBody Comix comix) {
        return repository.save(comix);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        repository.findById(id).orElseThrow(RuntimeException::new);
        repository.deleteById(id);
    }

    @PutMapping("/{id}")
    public Comix update(@PathVariable Long id, @RequestBody Comix comix) {
        if (comix.getId() != id)
            throw new RuntimeException();
        repository.findById(id).orElseThrow(RuntimeException::new);
        return repository.save(comix);
    }
}
