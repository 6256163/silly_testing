package com.frame.silly.com.frame.controller;

import com.frame.silly.com.frame.entity.Action;
import com.frame.silly.com.frame.entity.Testcase;
import com.frame.silly.com.frame.repository.FeatureRepository;
import com.frame.silly.com.frame.repository.ScenarioRepository;
import com.frame.silly.com.frame.repository.TestcaseRepository;
import com.frame.silly.com.frame.repository.TestcaseStepRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class TestcaseController {

    @Autowired
    TestcaseRepository repo;

    @Autowired
    TestcaseStepRepository repoStep;

    @Autowired
    FeatureRepository repoF;

    @Autowired
    ScenarioRepository repoS;

    @GetMapping("/testcase")
    public String getAll(Model model) {
        Iterable<Testcase> tcs = repo.findAllByOrderByTcId();
        model.addAttribute("testcases", tcs);
        model.addAttribute("testcase", new Testcase());
        return "testcase";
    }

    @GetMapping(path = "/testcase/{testcaseId}/step")
    public String getSteps(Model model, @PathVariable("testcaseId") Long testcaseId){
        model.addAttribute("testcase",repo.findOne(testcaseId));
        return "testcaseSteps::stepDetail";
    }


    @GetMapping(path = "/testcase/{testcaseId}")
    @ResponseBody
    public Testcase getOne(Model model,@PathVariable("testcaseId") Long testcaseId){
        return repo.findOne(testcaseId);
    }


    @GetMapping(value = "/testcase", params = {"like"})
    @ResponseBody
    public Iterable<Testcase> getOneByLike(Model model, @RequestParam(value = "like") String name) {
        return repo.findAllByTcIdContaining(name);
    }

    @PostMapping("/testcase")
    public String create(Model model, @ModelAttribute("testcase") Testcase testcase) {
        repo.save(testcase);
        return getAll(model);
    }

//    @PutMapping(value = "/testcase/{testcaseId}")
//    @ResponseBody
//    public Testcase modify(@PathVariable("testcaseId") Long testcaseId, Testcase testcase){
//
//    }

    @DeleteMapping(value = "/testcase/{testcaseId}", produces = "application/json")
    @ResponseBody
    public ResponseEntity delete(Model model, @PathVariable("testcaseId") Long testcaseId) {
        repo.delete(testcaseId);
        return ResponseEntity.noContent().build();

    }







}
