package com.frame.silly.com.frame.controller;

import com.frame.silly.com.frame.entity.Locator;
import com.frame.silly.com.frame.repository.ElementRepository;
import com.frame.silly.com.frame.repository.LocatorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class LocatorController {

    @Autowired
    LocatorRepository repo;

    @Autowired
    ElementRepository repoE;

    @GetMapping("/locator")
    public String getAll(Model model) {
        Iterable<Locator> locators = repo.findAllByOrderByIdDesc();
        model.addAttribute("locators", locators);
        model.addAttribute("locator", new Locator());

        return "locator";
    }

    @PostMapping("/locator")
    public String create(Model model, @ModelAttribute("locator") Locator locator) {
        repo.save(locator);
        return getAll(model);
    }

    @PutMapping(value = "/locator/{locatorId}")
    @ResponseBody
    public Locator modify(@PathVariable("locatorId") Long locatorId, Locator locator){
        Locator locatorNew = repo.findOne(locatorId);
        locatorNew.setName(locator.getName());
        repo.save(locatorNew);
        return locatorNew;
    }

    @DeleteMapping(value = "/locator/{locatorId}", produces = "application/json")
    @ResponseBody
    public ResponseEntity delete(Model model, @PathVariable("locatorId") Long locatorId) {
        if (repoE.findAllByLocatorId(locatorId).size() == 0){
            repo.delete(locatorId);
            return ResponseEntity.noContent().build();
        }
        else {
            return ResponseEntity.status(HttpStatus.IM_USED).build();
        }
    }







}
