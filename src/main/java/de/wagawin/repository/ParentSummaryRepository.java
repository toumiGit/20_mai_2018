package de.wagawin.repository;

import de.wagawin.entity.ParentSummary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ParentSummaryRepository extends JpaRepository<ParentSummary, Integer> {


    @Modifying
    @Query(value = "insert into parent_summary(amount_of_person, amount_of_children)\n" +
            "select count(*) as c, childNumber from \n" +
            "(SELECT parent_id, count(*) as childNumber FROM child group by parent_id) as T\n" +
            "group by childNumber;",
            nativeQuery = true)
    void updateParentWithChildren();

    @Modifying
    @Query(value = "insert into parent_summary(amount_Of_Person, amount_Of_Children)\n" +
            "select count(*), 0 from person p left join child c on p.id=c.parent_id \n" +
            "where c.parent_id is null;",
            nativeQuery = true)
    void updateParentWithoutChildren();

    @Query(value = "select * from parent_summary order by amount_of_children ASC",
            nativeQuery = true)
    List<ParentSummary> findAllReordered();

}
