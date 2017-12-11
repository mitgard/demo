package ru.rustam.demo.service;

import ru.rustam.demo.model.Disc;

import java.util.List;

public interface DiscService {

    Disc findByName(String name);
    List<Disc> findAll();
    void save(Disc name);
}
