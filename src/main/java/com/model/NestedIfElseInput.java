package com.model;

import lombok.Data;

@Data
public class NestedIfElseInput {
    private String condition1;
    private String condition2;
    private String trueStatement;
    private String falseStatement1;
    private String falseStatement2;

}