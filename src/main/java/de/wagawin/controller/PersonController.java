package de.wagawin.controller;

import de.wagawin.entity.ParentSummary;
import de.wagawin.repository.HouseRepository;
import de.wagawin.repository.ParentSummaryRepository;
import org.apache.commons.lang3.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.List;

import static java.lang.Math.toIntExact;

@Controller
@RequestMapping(value = "/person", produces = "application/json")
public class PersonController {

    @Autowired
    ParentSummaryRepository repository;

    @GetMapping("children")
    public @ResponseBody
    long[] getParentSummary() {
        List<ParentSummary> summaries = repository.findAllReordered();
        Validate.notNull(summaries);

        long[] result = new long[toIntExact(summaries.get(summaries.size() - 1).getAmountOfChildren()) + 1 ];
        Arrays.fill(result, 0);
        summaries.forEach(it -> {
            result[toIntExact(it.getAmountOfChildren())] = it.getAmountOfPerson();
        });

        return result;
    }
}
