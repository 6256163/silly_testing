package com.frame.silly.com.frame.controller;

import com.frame.silly.com.frame.entity.Feature;
import com.frame.silly.com.frame.entity.Scenario;
import com.frame.silly.com.frame.repository.FeatureRepository;
import com.frame.silly.com.frame.repository.ScenarioRepository;
import com.frame.silly.com.frame.repository.ScenarioRepository;
import com.frame.silly.com.frame.repository.TestcaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class ScenarioController {

    @Autowired
    ScenarioRepository repo;

    @Autowired
    TestcaseRepository repoT;

    @Autowired
    FeatureRepository repoF;
    

    @GetMapping("/scenario")
    public String getAll(Model model) {
        model.addAttribute("scenarios", repo.findAllByOrderByCodeAsc());
        model.addAttribute("scenario", new Scenario());
        model.addAttribute("feature", new Feature());
        return "scenario";
    }

    @GetMapping("/scenario/{scenarioId}")
    @ResponseBody
    public Scenario getOne(Model model, @PathVariable("scenarioId") Long scenarioId) {
        return repo.findOne(scenarioId);
    }


    @GetMapping(path = "/feature/{featureId}/scenario")
    public String getScenarios(Model model, @PathVariable("featureId") Long featureId){
        model.addAttribute("scenarios", repo.findAllByFeatureId(featureId));
        model.addAttribute("scenario", new Scenario());
        model.addAttribute("feature", repoF.findOne(featureId));
        return "scenario";
    }

    @GetMapping(value = "/scenario", params = {"like"})
    @ResponseBody
    public Iterable<Scenario> getOneByLike(Model model, @RequestParam(value = "like") String name) {
        return repo.findAllByNameContaining(name);
    }

    @PostMapping("/scenario")
    public String create(Model model, @ModelAttribute("scenario") Scenario scenario) {
        repo.save(scenario);
        return getAll(model);
    }

    @PutMapping(value = "/scenario/{scenarioId}")
    @ResponseBody
    public Scenario modify(@PathVariable("scenarioId") Long scenarioId, Scenario scenario){
        Scenario scenarioNew = repo.findOne(scenarioId);
        scenarioNew.setName(scenario.getName());
        repo.save(scenarioNew);
        return scenarioNew;
    }

    @DeleteMapping(value = "/scenario/{scenarioId}", produces = "application/json")
    @ResponseBody
    public ResponseEntity delete(Model model, @PathVariable("scenarioId") Long scenarioId) {
        if (repoT.findAllByScenarioId(scenarioId).size() == 0){
            repo.delete(scenarioId);
            return ResponseEntity.noContent().build();
        }
        else {
            return ResponseEntity.status(HttpStatus.IM_USED).build();
        }
    }







}
