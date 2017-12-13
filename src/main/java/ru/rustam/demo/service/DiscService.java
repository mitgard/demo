package ru.rustam.demo.service;

import ru.rustam.demo.model.Disc;
import ru.rustam.demo.model.User;

import java.util.List;

public interface DiscService {

    Disc findByName(String name);
    List<Disc> findAll();
    void save(Disc disc);
    List<Disc> findDiscsByOwnerIs(User user);
    List<Disc> findDiscByRenterIs(User user);
    void updateRenter( int user_id, int disc_id);
    void deleteRenter(int disc_id);
}
