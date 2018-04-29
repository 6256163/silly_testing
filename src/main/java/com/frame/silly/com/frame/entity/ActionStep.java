package com.frame.silly.com.frame.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jdk.nashorn.internal.ir.annotations.Ignore;
import lombok.Getter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class ActionStep extends AbstractEntity {

    @JoinColumn(nullable = false)
    private float sort;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    @JsonIgnore
    private Action action;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Element element;

    private String move;

    private boolean hasArg;

    public float getSort() {
        return sort;
    }

    public void setSort(float sort) {
        this.sort = sort;
    }

    public Element getElement(){
        return element;
    }

    public void setElement(Element element) {
        this.element = element;
    }

    public String getMove(){
        return move;
    }

    public void setMove(String move) {
        this.move = move;
    }

    public boolean getHasArg(){
        return hasArg;
    }

    public void setHasArg(boolean hasArg) {
        this.hasArg = hasArg;
    }

    public Action getAction(){
        return action;
    }

    public void setAction(Action action) {
        this.action = action;
    }
}
