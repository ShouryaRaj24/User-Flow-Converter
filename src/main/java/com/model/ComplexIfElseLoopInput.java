package com.model;

import lombok.Data;

@Data
public class ComplexIfElseLoopInput {
    private String arrayInitialization;
    private String conditionVariable;
    private String mainCondition;
    private String trueBlockPrint;
    private String falseBlockPrint;
    private LoopInput trueLoop;
    private LoopInput falseLoop;
}