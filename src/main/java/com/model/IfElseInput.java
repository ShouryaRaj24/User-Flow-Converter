package com.model;

import lombok.Data;

@Data
public class IfElseInput {
    private String condition;
    private String trueStatement;
    private String falseStatement;
    
    private IfElseInput innerIfElse;  // New field for nested if-else
}
