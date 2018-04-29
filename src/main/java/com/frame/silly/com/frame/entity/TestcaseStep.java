package com.frame.silly.com.frame.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class TestcaseStep extends AbstractEntity{

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    @JsonIgnore
    private Testcase testcase;

    @JoinColumn(nullable = false)
    @Getter
    @Setter
    private float sort;

    @JoinColumn(nullable = false)
    @Getter
    @Setter
    private int type;




}
