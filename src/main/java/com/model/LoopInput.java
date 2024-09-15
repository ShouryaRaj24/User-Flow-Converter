package com.model;


import lombok.Data;

@Data
public class LoopInput {
    private String initialization;
    private String condition;
    private String update;
    private String checkCondition;
    private String statement;

    private LoopInput innerLoop;  // New field for nested loop

}