package com.service;

import org.springframework.stereotype.Service;

import com.model.ComplexIfElseLoopInput;
import com.model.ComplexLoopInput;
import com.model.IfElseInput;
import com.model.LoopInput;
import com.model.NestedIfElseInput;

import com.model.SwitchCaseInput;

@Service
public class FlowDiagramService {

    public String convertIfElse(IfElseInput input) {
    	
        StringBuilder code = new StringBuilder();
        code.append("public static void main(String[] args) {\n");
        code.append("    if (").append(input.getCondition()).append(") {\n");
        code.append("        ").append(input.getTrueStatement()).append("\n");
        code.append("    } else {\n");
        code.append("        ").append(input.getFalseStatement()).append("\n");
        code.append("    }\n");
        code.append("}");
        return code.toString();
    }

    public String convertNestedIfElse(NestedIfElseInput input) {
        StringBuilder code = new StringBuilder();
        code.append("public static void main(String[] args) {\n");
        code.append("    if (").append(input.getCondition1()).append(") {\n");
        code.append("        if (").append(input.getCondition2()).append(") {\n");
        code.append("            ").append(input.getTrueStatement()).append("\n");
        code.append("        } else {\n");
        code.append("            ").append(input.getFalseStatement1()).append("\n");
        code.append("        }\n");
        code.append("    } else {\n");
        code.append("        ").append(input.getFalseStatement2()).append("\n");
        code.append("    }\n");
        code.append("}");
        return code.toString();
    }

    public String convertLoop(LoopInput input) {
    	System.out.println(input);
        StringBuilder code = new StringBuilder();
        code.append("public static void main(String[] args) {\n");
        code.append("    for (").append(input.getInitialization()).append("; ")
            .append(input.getCondition()).append("; ")
            .append(input.getUpdate()).append(") {\n");
        code.append("        if (").append(input.getCheckCondition()).append(") {\n");
        code.append("            ").append(input.getStatement()).append("\n");
        code.append("        } else {\n");
        code.append("            break;\n");
        code.append("        }\n");
        code.append("    }\n");
        code.append("}");
        return code.toString();
    }

    

    public String convertSwitchCase(SwitchCaseInput input) {
        StringBuilder code = new StringBuilder();
        code.append("public static void main(String[] args) {\n");
        code.append("    int condition = ").append(input.getInitialization()).append(";\n");
        code.append("    switch (condition) {\n");
        for (SwitchCaseInput.Case caseInput : input.getCases()) {
            code.append("        case ").append(caseInput.getValue()).append(":\n");
            code.append("            ").append(caseInput.getStatement()).append("\n");
            code.append("            break;\n");
        }
        code.append("        default:\n");
        code.append("            ").append(input.getDefaultStatement()).append("\n");
        code.append("            break;\n");
        code.append("    }\n");
        code.append("}");
        return code.toString();
    }
    
    public String convertComplexLoop(ComplexLoopInput input) {
        StringBuilder code = new StringBuilder();
        code.append("public static void main(String[] args) {\n");
        code.append("    ").append(input.getArrayInitialization()).append(";\n");
        code.append("    for (").append(input.getLoopInitialization()).append("; ")
            .append(input.getLoopCondition()).append("; ")
            .append(input.getLoopUpdate()).append(") {\n");
        code.append("        if (").append(input.getIfCondition()).append(") {\n");
        code.append("            ").append(input.getIfStatement()).append("\n");
        code.append("        } else {\n");
        code.append("            ").append(input.getElseStatement()).append("\n");
        code.append("        }\n");
        code.append("    }\n");
        code.append("}");
        return code.toString();
    }
    
    public String convertComplexIfElseLoop(ComplexIfElseLoopInput input) {
        StringBuilder code = new StringBuilder();
        code.append("public static void main(String[] args) {\n");
        code.append("    ").append(input.getArrayInitialization()).append(";\n");
        code.append("    ").append(input.getConditionVariable()).append(";\n\n");
        code.append("    if (").append(input.getMainCondition()).append(") {\n");
        code.append("        ").append(input.getTrueBlockPrint()).append("\n\n");
        appendLoopCode(code, input.getTrueLoop());
        code.append("    } else {\n");
        code.append("        ").append(input.getFalseBlockPrint()).append("\n\n");
        appendLoopCode(code, input.getFalseLoop());
        code.append("    }\n");
        code.append("}");
        return code.toString();
    }

    private void appendLoopCode(StringBuilder code, LoopInput loopInput) {
        code.append("        for (").append(loopInput.getInitialization()).append("; ")
            .append(loopInput.getCondition()).append("; ")
            .append(loopInput.getUpdate()).append(") {\n");
        code.append("            if (").append(loopInput.getCheckCondition()).append(") {\n");
        code.append("                ").append(loopInput.getStatement()).append("\n");
        code.append("            }\n");
        code.append("        }\n");
    }
    
    public String convertMultipleNestedLoop(LoopInput outerLoop) {
    	System.out.println(outerLoop);
        StringBuilder code = new StringBuilder();
        code.append("public static void main(String[] args) {\n");
        appendNestedLoop(code, outerLoop, 1);
        code.append("}");
        return code.toString();
    }

    private void appendNestedLoop(StringBuilder code, LoopInput loopInput, int indentLevel) {
        String indent = "    ".repeat(indentLevel);
        code.append(indent).append("for (").append(loopInput.getInitialization()).append("; ")
            .append(loopInput.getCondition()).append("; ")
            .append(loopInput.getUpdate()).append(") {\n");
        
        if (loopInput.getCheckCondition() != null && !loopInput.getCheckCondition().equals("true")) {
            code.append(indent).append("    if (").append(loopInput.getCheckCondition()).append(") {\n");
            code.append(indent).append("        ").append(loopInput.getStatement()).append("\n");
            code.append(indent).append("    }\n");
        } else {
            code.append(indent).append("    ").append(loopInput.getStatement()).append("\n");
        }

        if (loopInput.getInnerLoop() != null) {
            appendNestedLoop(code, loopInput.getInnerLoop(), indentLevel + 1);
        }
        
        code.append(indent).append("}\n");
    }
    
}