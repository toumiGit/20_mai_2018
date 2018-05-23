package de.wagawin.controller;

import de.wagawin.entity.Child;
import de.wagawin.entity.Daughter;
import de.wagawin.entity.Son;
import de.wagawin.exception.ColorException;
import de.wagawin.factory.ChildInfoFactory;
import de.wagawin.repository.ChildRepository;
import de.wagawin.view.ChildInfo;
import org.apache.commons.lang3.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/child", produces = "application/json")
public class ChildController {

    @Autowired
    ChildInfoFactory factory;

    @Autowired
    ChildRepository childRepository;

    @GetMapping("/info")
    public @ResponseBody
    ChildInfo getChildInfo(@RequestParam int childId) {
        return factory.getChildInfo(childId);
    }

    @GetMapping("/color")
    public @ResponseBody
    String getColor(@RequestParam int childId) throws ColorException {
        Child child = childRepository.findOne(childId);
        Validate.notNull(child);
        if (child instanceof Daughter)
            return ((Daughter) child).getHairColor();
        if (child instanceof Son)
            return ((Son) child).getBicycleColor();
        throw new ColorException("request color for child without sex specified");
    }
}
