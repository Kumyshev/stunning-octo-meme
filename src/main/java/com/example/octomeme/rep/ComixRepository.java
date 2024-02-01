package com.example.octomeme.rep;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import com.example.octomeme.model.Comix;

public interface ComixRepository extends CrudRepository<Comix, Long> {
    ArrayList<Comix> findByAuthor(String author);
}
