package com.frame.silly.com.frame.controller;

import com.frame.silly.com.frame.entity.Page;
import com.frame.silly.com.frame.repository.ElementRepository;
import com.frame.silly.com.frame.repository.PageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class PageController {

    @Autowired
    PageRepository repo;

    @Autowired
    ElementRepository repoE;

    @GetMapping("/page")
    public String getAll(Model model) {
        Iterable<Page> pages = repo.findAllByOrderByIdDesc();
        model.addAttribute("pages", pages);
        model.addAttribute("page", new Page());
        return "page";
    }

    @GetMapping(value = "/page", params = {"like"})
    @ResponseBody
    public Iterable<Page> getOneByLike(Model model, @RequestParam(value = "like") String name) {
        return repo.findAllByNameContaining(name);
    }

    @PostMapping("/page")
    public String create(Model model, @ModelAttribute("page") Page page) {
        repo.save(page);
        return getAll(model);
    }

    @PutMapping(value = "/page/{pageId}")
    @ResponseBody
    public Page modify(@PathVariable("pageId") Long pageId, Page page){
        Page pageNew = repo.findOne(pageId);
        pageNew.setName(page.getName());
        repo.save(pageNew);
        return pageNew;
    }

    @DeleteMapping(value = "/page/{pageId}", produces = "application/json")
    @ResponseBody
    public ResponseEntity delete(Model model, @PathVariable("pageId") Long pageId) {
        if (repoE.findAllByPageId(pageId).size() == 0){
            repo.delete(pageId);
            return ResponseEntity.noContent().build();
        }
        else {
            return ResponseEntity.status(HttpStatus.IM_USED).build();
        }
    }







}
