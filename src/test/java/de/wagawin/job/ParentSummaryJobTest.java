package de.wagawin.job;

import de.wagawin.entity.ParentSummary;
import de.wagawin.repository.ParentSummaryRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @Author toumi on 23.05.18.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ParentSummaryJobTest {

    @Autowired
    ParentSummaryJob job;

    @Autowired
    ParentSummaryRepository repository;

    @Test
    public void parentSummaryCalculator() throws Exception {
        job.parentSummaryCalculator();
        List<ParentSummary> result = repository.findAll();
        assertEquals(3, result.size());

        ParentSummary[] expected = new ParentSummary[]{
                new ParentSummary(1L, 1L),
                new ParentSummary(1L, 3L),
                new ParentSummary(1L, 0L)
        };

        Arrays.stream(expected).forEach(it-> {
            assert result.contains(it);
        });
    }

}