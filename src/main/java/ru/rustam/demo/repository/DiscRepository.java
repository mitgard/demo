package ru.rustam.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.rustam.demo.model.Disc;
import ru.rustam.demo.model.User;

import javax.transaction.Transactional;
import java.util.List;

@Repository("discRepository")
public interface DiscRepository extends JpaRepository<Disc, Long> {

    List<Disc> findAll();

    Disc findByName(String name);

    List<Disc> findDiscsByOwnerIs(User user);

    List<Disc> findDiscsByRenterIs(User user);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO disc_changer(disc_id, user_id) VALUES (:disc_id, :user_id) ON CONFLICT (disc_id) DO UPDATE SET user_id = :user_id", nativeQuery = true)
    void updateRenter(@Param("user_id") int user_id, @Param("disc_id") int disc_id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE disc_changer SET user_id = NULL WHERE disc_id = :disc_id", nativeQuery = true)
    void deleteRenter(@Param("disc_id") int disc_id);
}
