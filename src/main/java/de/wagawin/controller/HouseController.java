package de.wagawin.controller;

import de.wagawin.entity.House;
import de.wagawin.repository.HouseRepository;
import org.apache.commons.lang3.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/house", produces = "application/json")
public class HouseController {

    @Autowired
    HouseRepository houseRepository;

    @GetMapping("")
    public @ResponseBody
    House getHause(@RequestParam int personId) {
        House result =  houseRepository.getById(personId);
        Validate.notNull(result);
        return result;
    }
}
