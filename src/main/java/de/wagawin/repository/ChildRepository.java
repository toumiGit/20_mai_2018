package de.wagawin.repository;

import de.wagawin.entity.Child;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ChildRepository extends JpaRepository<Child, Integer> {

    @Query(value = "select count(*) c from child group by parent_id order by c desc limit 1;",nativeQuery = true)
    public int maxChildrenPerPerson();
}
