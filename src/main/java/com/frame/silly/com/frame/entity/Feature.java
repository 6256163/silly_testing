package com.frame.silly.com.frame.entity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;

@Entity
public class Feature extends AbstractEntity{


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

}
