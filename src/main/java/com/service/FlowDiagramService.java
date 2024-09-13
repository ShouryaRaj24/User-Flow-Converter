package com.service;

import org.springframework.stereotype.Service;

import com.model.IfElseInput;
import com.model.LoopInput;
import com.model.NestedIfElseInput;
import com.model.NestedLoopInput;
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

    public String convertNestedLoop(NestedLoopInput input) {
        StringBuilder code = new StringBuilder();
        code.append("public static void main(String[] args) {\n");
        code.append("    for (").append(input.getInitialization1()).append("; ")
            .append(input.getCondition1()).append("; ")
            .append(input.getUpdate1()).append(") {\n");
        code.append("        for (").append(input.getInitialization2()).append("; ")
            .append(input.getCondition2()).append("; ")
            .append(input.getUpdate2()).append(") {\n");
        code.append("            ").append(input.getStatement()).append("\n");
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
}