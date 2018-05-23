package de.wagawin.repository;

import de.wagawin.entity.House;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HouseRepository extends JpaRepository<House, Integer> {

    House getById(Integer id);
}
