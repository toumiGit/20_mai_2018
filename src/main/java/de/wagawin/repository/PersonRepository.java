package de.wagawin.repository;

import de.wagawin.entity.Person;
import de.wagawin.entity.Son;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PersonRepository extends JpaRepository<Person, Integer> {

}
