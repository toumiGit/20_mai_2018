package de.wagawin.repository;

import de.wagawin.view.ChildInfoView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ChildInfoViewRepository extends JpaRepository<ChildInfoView, Integer> {

    @Query(value = "select * from child_info_view where id= ?1",
            nativeQuery = true)
    ChildInfoView getById(Integer id);
}
