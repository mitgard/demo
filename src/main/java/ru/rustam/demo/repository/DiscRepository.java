package ru.rustam.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.rustam.demo.model.Disc;

import java.util.List;

@Repository("discRepository")
public interface DiscRepository extends JpaRepository<Disc, Long> {

    List<Disc> findAll();

    Disc findByName(String name);

}
