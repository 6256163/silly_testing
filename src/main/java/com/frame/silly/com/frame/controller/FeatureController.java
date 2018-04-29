package com.frame.silly.com.frame.controller;

import com.frame.silly.com.frame.entity.Feature;
import com.frame.silly.com.frame.entity.Feature;
import com.frame.silly.com.frame.entity.Scenario;
import com.frame.silly.com.frame.entity.Testcase;
import com.frame.silly.com.frame.repository.ElementRepository;
import com.frame.silly.com.frame.repository.FeatureRepository;
import com.frame.silly.com.frame.repository.FeatureRepository;
import com.frame.silly.com.frame.repository.ScenarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class FeatureController {

    @Autowired
    FeatureRepository repo;

    @Autowired
    ScenarioRepository repoS;
    

    @GetMapping("/feature")
    public String getAll(Model model) {
        Iterable<Feature> features = repo.findAllByOrderByCodeAsc();
        model.addAttribute("features", features);
        model.addAttribute("feature", new Feature());
        return "feature";
    }

    @GetMapping("/features")
    @ResponseBody
    public Iterable<Feature> getAllByAjax(Model model) {
        return repo.findAllByOrderByCodeAsc();
    }

    @GetMapping(path = "/feature/{featureId}")
    @ResponseBody
    public Feature getOne(Model model, @PathVariable("featureId") Long featuresId){
        return repo.findOne(featuresId);
    }

    @GetMapping(value = "/feature", params = {"like"})
    @ResponseBody
    public Iterable<Feature> getOneByLike(Model model, @RequestParam(value = "like") String name) {
        return repo.findAllByNameContaining(name);
    }

    @PostMapping("/feature")
    public String create(Model model, @ModelAttribute("feature") Feature feature) {
        repo.save(feature);
        return getAll(model);
    }

    @PutMapping(value = "/feature/{featureId}")
    @ResponseBody
    public Feature modify(@PathVariable("featureId") Long featureId, Feature feature){
        Feature featureNew = repo.findOne(featureId);
        featureNew.setName(feature.getName());
        repo.save(featureNew);
        return featureNew;
    }

    @DeleteMapping(value = "/feature/{featureId}", produces = "application/json")
    @ResponseBody
    public ResponseEntity delete(Model model, @PathVariable("featureId") Long featureId) {
        if (repoS.findAllByFeatureId(featureId).size() == 0){
            repo.delete(featureId);
            return ResponseEntity.noContent().build();
        }
        else {
            return ResponseEntity.status(HttpStatus.IM_USED).build();
        }
    }







}
