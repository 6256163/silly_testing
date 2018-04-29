package com.frame.silly.com.frame.controller;

import com.frame.silly.com.frame.entity.Action;
import com.frame.silly.com.frame.entity.ActionStep;
import com.frame.silly.com.frame.repository.ActionRepository;
import com.frame.silly.com.frame.repository.ActionStepRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class ActionStepController {

    @Autowired
    ActionStepRepository repo;

    @Autowired
    ActionRepository repoA;

    @PostMapping(path = "/action_step")
    @ResponseBody
    public Action updateSteps(ActionStep step, Model model){
        repo.save(step);
        return repoA.findOne(step.getAction().getId());
    }

    @DeleteMapping("/action_step/{stepId}")
    @ResponseBody
    public void getSteps(@PathVariable("stepId") Long stepId) {
        repo.delete(stepId);
    }









}
