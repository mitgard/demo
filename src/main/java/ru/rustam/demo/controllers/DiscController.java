package ru.rustam.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.rustam.demo.model.Disc;
import ru.rustam.demo.model.User;
import ru.rustam.demo.service.DiscService;
import ru.rustam.demo.service.UserService;

import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class DiscController {

    @Autowired
    private DiscService discService;

    @Autowired
    private UserService userService;

    @GetMapping(value = "/discs", produces = "Application/json")
    public ResponseEntity discs() {
        List<Disc> list = discService.findAll();
        return ResponseEntity.ok(hydePwd(list));
    }

    @RequestMapping(value = "/disc/add", method = RequestMethod.POST)
    public ResponseEntity addDisc(@RequestBody Disc disc) {
        Disc discCheck = discService.findByName(disc.getName());
        if (discCheck == null) {
            discService.save(disc);
            return ResponseEntity.ok(disc);
        } else return ResponseEntity.ok("Disc with this name was already exist.");
    }

    @RequestMapping(value = "/disc/get", method = RequestMethod.POST)
    public ResponseEntity getDisc(@RequestBody Disc disc, Principal principal) {
        Disc discCheck = discService.findByName(disc.getName());
        if (discCheck.getRenter() == null) {
            User renter = userService.findUserByUsername(principal.getName());
            discService.updateRenter(renter.getId(), disc.getDisc_id());
            return ResponseEntity.ok(disc);
        } else return ResponseEntity.ok("Disc is not free.");
    }

    @RequestMapping(value = "/disc/return", method = RequestMethod.POST)
    public ResponseEntity returnDisc(@RequestBody Disc disc) {
        Disc discCheck = discService.findByName(disc.getName());
        if (discCheck.getRenter() != null) {
            discService.deleteRenter(disc.getDisc_id());
            return ResponseEntity.ok(disc);
        } else return ResponseEntity.ok("Disc is not free.");
    }

    @GetMapping(value = "/discs/owner", produces = "Application/json")
    public ResponseEntity discsByOwner(@RequestBody String username) {
        User user = userService.findUserByUsername(username);
        List<Disc> list = discService.findDiscsByOwnerIs(user);
        return ResponseEntity.ok(hydePwd(list));
    }

    @GetMapping(value = "/discs/my", produces = "Application/json")
    public ResponseEntity myDiscs(Principal principal) {
        User user = userService.findUserByUsername(principal.getName());
        List<Disc> list = discService.findDiscsByOwnerIs(user);
        return ResponseEntity.ok(hydePwd(list));
    }

    @GetMapping(value = "/discs/free", produces = "Application/json")
    public ResponseEntity freeDiscs(){
        List<Disc> list = discService.findDiscByRenterIs(null);
        return ResponseEntity.ok(hydePwd(list));
    }

    @GetMapping(value = "/discs/user/rent", produces = "Application/json")
    public ResponseEntity discsRent(Principal principal){
        User user = userService.findUserByUsername(principal.getName());
        List<Disc> list = discService.findDiscByRenterIs(user);
        return ResponseEntity.ok(hydePwd(list));
    }

    @GetMapping(value = "/discs/owner/nonfree", produces = "Application/json")
    public ResponseEntity discsNonFree(Principal principal){
        User user = userService.findUserByUsername(principal.getName());
        List<Disc> list = discService.findDiscsByOwnerIs(user).stream().filter(disc -> disc.getRenter() != null).collect(Collectors.toList());
        return ResponseEntity.ok(hydePwd(list));
    }

    List<Disc> hydePwd(List<Disc> list){
        list.forEach(disc -> {
                    disc.setUser_id(new User(disc.getUser_id().getUsername(), null, disc.getUser_id().getName(), disc.getUser_id().getPhone()));
                    if(disc.getRenter() != null)
                    disc.setRenter(new User(disc.getRenter().getUsername(), null, disc.getRenter().getName(), disc.getRenter().getPhone()));
                });
        return list;
    }
}
