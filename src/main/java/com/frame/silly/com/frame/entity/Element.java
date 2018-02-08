package com.frame.silly.com.frame.entity;

import javax.persistence.*;

@Entity
public class Element extends AbstractEntity {

    @JoinColumn(nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Page page;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Locator locator;

    @JoinColumn(nullable = false)
    private String value;

    public Element() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Locator getLocator() {
        return locator;
    }

    public void setLocator(Locator locator) {
        this.locator = locator;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }


}
