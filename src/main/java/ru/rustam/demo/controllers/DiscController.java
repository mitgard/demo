package ru.rustam.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.rustam.demo.model.Disc;
import ru.rustam.demo.service.DiscService;

import java.util.List;

@Controller
public class DiscController {

    @Autowired
    private DiscService discService;

    @GetMapping(value = "/discs", produces = "Application/json")
    public ResponseEntity discs() {
        List<Disc> list = discService.findAll();
        return ResponseEntity.ok(list);
    }

    @RequestMapping(value = "/disc/add", method = RequestMethod.POST)
    public ResponseEntity addDisc(@RequestBody Disc disc) {
        Disc discCheck = discService.findByName(disc.getName());
        if (discCheck == null) {
            discService.save(disc);
            return ResponseEntity.ok(disc);
        } else return ResponseEntity.ok("Disc with this username was already exist.");
    }

}
