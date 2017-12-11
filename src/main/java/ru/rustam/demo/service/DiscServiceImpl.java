package ru.rustam.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.rustam.demo.model.Disc;
import ru.rustam.demo.repository.DiscRepository;

import java.util.List;

@Service("discService")
public class DiscServiceImpl implements DiscService{

    @Qualifier("discRepository")
    @Autowired
    private DiscRepository discRepository;

    public Disc findByName(String name) {
        return discRepository.findByName(name);
    }

    public List<Disc> findAll() {
        return discRepository.findAll();
    }

    public void save(Disc disc) {
        discRepository.save(disc);
    }
}
