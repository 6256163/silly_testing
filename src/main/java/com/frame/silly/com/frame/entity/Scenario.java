package com.frame.silly.com.frame.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Scenario extends AbstractEntity{


    @JoinColumn(nullable = false)
    @Getter
    @Setter
    private String name;

    @JoinColumn(nullable = false)
    @Getter
    @Setter
    private String code;

    @JoinColumn(nullable = false)
    @Getter
    @Setter
    private String description;

    @JoinColumn(nullable = false)
    @Getter
    @Setter
    private boolean active;

    @ManyToOne
    @JoinColumn(nullable = false)
    @Getter
    @Setter
    private Feature feature;

}
