package de.wagawin.job;

import de.wagawin.repository.ParentSummaryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
public class ParentSummaryJob {

    @Autowired
    ParentSummaryRepository parentSummaryRepository;

    @Transactional
    @Scheduled(fixedDelayString = "${job.parentSummary.fixed.delay.seconds}000",
            initialDelayString = "${job.parentSummary.fixed.initial.seconds}000")
    public void parentSummaryCalculator() {
        log.info("job running to calculate parent summary job");
        parentSummaryRepository.deleteAll();
        updateParentSummary();
        log.info("job over");
    }

    private void updateParentSummary() {
        parentSummaryRepository.updateParentWithChildren();
        parentSummaryRepository.updateParentWithoutChildren();
    }

}
