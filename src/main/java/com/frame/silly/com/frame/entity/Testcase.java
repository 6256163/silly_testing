package com.frame.silly.com.frame.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Testcase extends AbstractEntity{

    @JoinColumn(nullable = false)
    @Getter
    @Setter
    private String tcId;

    @JoinColumn(nullable = false)
    @Getter
    @Setter
    private String summary;

    @JoinColumn(nullable = false)
    @Getter
    @Setter
    private boolean active;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    @JsonIgnore
    @Getter
    @Setter
    private Scenario scenario;

    public Testcase(){}


}
