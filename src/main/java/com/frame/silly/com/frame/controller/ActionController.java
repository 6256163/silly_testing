package com.frame.silly.com.frame.controller;

import com.frame.silly.com.frame.entity.Action;
import com.frame.silly.com.frame.repository.ElementRepository;
import com.frame.silly.com.frame.repository.ActionStepRepository;
import com.frame.silly.com.frame.repository.ActionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class ActionController {

    @Autowired
    ActionRepository repo;

    @Autowired
    ActionStepRepository repoS;

    @Autowired
    ElementRepository repoE;

    @GetMapping("/action")
    public String getAll(Model model) {
        Iterable<Action> actions = repo.findAllByOrderByName();
        model.addAttribute("actions", actions);
        model.addAttribute("action", new Action());
        return "action";
    }

    @GetMapping(path = "/action/{actionId}/step")
    @ResponseBody
    public Action getSteps(Model model, @PathVariable("actionId") Long actionId){
        return repo.findOne(actionId);
    }


    @GetMapping(path = "/action/{actionId}")
    public String getOne(Model model,@PathVariable("actionId") Long actionId){
        Action action = repo.findOne(actionId);
        model.addAttribute("action", action);
        model.addAttribute("elements", repoE.findAllByOrderByPage());
        return "actionSteps::stepDetail";
        //return repo.findOne(actionId);
    }


    @GetMapping(value = "/action", params = {"like"})
    @ResponseBody
    public Iterable<Action> getOneByLike(Model model, @RequestParam(value = "like") String name) {
        return repo.findAllByNameContaining(name);
    }

    @PostMapping("/action")
    public String create(Model model, @ModelAttribute("action") Action action) {
        repo.save(action);
        return getAll(model);
    }

    @PutMapping(value = "/action/{actionId}")
    @ResponseBody
    public Action modify(@PathVariable("actionId") Long actionId, Action action){
        Action actionNew = repo.findOne(actionId);
        actionNew.setName(action.getName());
        repo.save(actionNew);
        return actionNew;
    }

    @DeleteMapping(value = "/action/{actionId}", produces = "application/json")
    @ResponseBody
    public ResponseEntity delete(Model model, @PathVariable("actionId") Long actionId) {
        repo.delete(actionId);
        return ResponseEntity.noContent().build();

    }







}
