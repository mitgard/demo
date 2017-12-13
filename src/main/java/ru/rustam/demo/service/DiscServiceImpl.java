package ru.rustam.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.rustam.demo.model.Disc;
import ru.rustam.demo.model.User;
import ru.rustam.demo.repository.DiscRepository;

import java.util.List;

@Service("discService")
public class DiscServiceImpl implements DiscService{

    @Qualifier("discRepository")
    @Autowired
    private DiscRepository discRepository;

    @Override
    public Disc findByName(String name) {
        return discRepository.findByName(name);
    }

    @Override
    public List<Disc> findAll() {
        return discRepository.findAll();
    }

    @Override
    public void save(Disc disc) {
        discRepository.save(disc);
    }

    @Override
    public List<Disc> findDiscsByOwnerIs(User user) {
        return discRepository.findDiscsByOwnerIs(user);
    }

    @Override
    public List<Disc> findDiscByRenterIs(User user) {
        return discRepository.findDiscsByRenterIs(user);
    }

}
