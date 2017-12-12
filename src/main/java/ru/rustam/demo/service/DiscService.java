package ru.rustam.demo.service;

import ru.rustam.demo.model.Disc;
import ru.rustam.demo.model.User;

import java.util.List;

public interface DiscService {

    Disc findByName(String name);
    List<Disc> findAll();
    void save(Disc name);
    List<Disc> findDiscsByUser_id(User user);
    List<Disc> findDiscByRenterIs(User user);
}
