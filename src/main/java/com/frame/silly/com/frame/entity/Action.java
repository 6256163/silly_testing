package com.frame.silly.com.frame.entity;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Action extends AbstractEntity {

    @NotNull
    @NotEmpty
    @NotBlank
    private String name;

    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "action")
    @OrderBy("sort")
    private List<ActionStep> actionSteps = new ArrayList<ActionStep>();

    public Action(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ActionStep> getActionSteps(){
        return actionSteps;
    }

    public void setActionSteps(List<ActionStep> actionSteps) {
        this.actionSteps = actionSteps;
    }
}
