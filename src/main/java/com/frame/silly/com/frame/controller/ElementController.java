package com.frame.silly.com.frame.controller;

import com.frame.silly.com.frame.entity.Element;
import com.frame.silly.com.frame.entity.Page;
import com.frame.silly.com.frame.repository.ElementRepository;
import com.frame.silly.com.frame.repository.PageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class ElementController {

    @Autowired
    ElementRepository repo;

    @Autowired
    PageRepository repoP;

    @GetMapping(value = "/element/{eleId}")
    @ResponseBody
    public Element getOne(@PathVariable("eleId") Long eleId){
        return repo.findOne(eleId);
    }

    @GetMapping("/element")
    public String getAll(Model model) {
        // add all elements
        model.addAttribute("elements", repo.findAll());
        // add empty element object
        model.addAttribute("element", new Element());
        model.addAttribute("page", new Page());
        // add all pages
        model.addAttribute("pages",repoP.findAllByOrderByIdDesc());
        return "element";
    }

    @GetMapping("/page/{pageId}/element")
    public String getAllByPage(Model model, @PathVariable("pageId") Long pageId) {
        Page page = repoP.findOne(pageId);
        Iterable<Element> elements = repo.findAllByPageOrderByIdDesc(page);
        // add all element in current page
        model.addAttribute("elements", elements);
        // add empty element object
        model.addAttribute("element", new Element());
        // add current page object
        model.addAttribute("page", page);
        // add all pages
        model.addAttribute("pages",repoP.findAllByOrderByIdDesc());
        return "element";
    }

    @GetMapping("/pages/{pageId}/elements")
    @ResponseBody
    public Iterable<Element> getAllByPageByAjax(Model model, @PathVariable("pageId") Long pageId) {
        Page page = repoP.findOne(pageId);
        return repo.findAllByPageOrderByIdDesc(page);
    }

    @PostMapping("/page/{pageId}/element")
    public String create(Model model, @PathVariable("pageId") Long pageId, Element element) {
        repo.save(element);
        return getAllByPage(model, pageId);
    }

    @PostMapping("/element")
    public String createWithoutPage(Model model, Element element) {
        repo.save(element);
        return getAll(model);
    }

    @DeleteMapping(value = "/element/{eleId}", produces = "application/json")
    @ResponseBody
    public void delete(Model model, @PathVariable("eleId") Long eleId) {
        repo.delete(eleId);
    }







}
