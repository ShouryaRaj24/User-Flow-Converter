package com.model;


import lombok.Data;

@Data
public class NestedLoopInput {
    private String initialization1;
    private String condition1;
    private String update1;
    private String initialization2;
    private String condition2;
    private String update2;
    private String statement;


}