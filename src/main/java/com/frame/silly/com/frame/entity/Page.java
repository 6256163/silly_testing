package com.frame.silly.com.frame.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;

@Entity
public class Page extends AbstractEntity {

    @JoinColumn(nullable = false)
    private String name;

    public Page(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString(){
        return name;
    }
}
