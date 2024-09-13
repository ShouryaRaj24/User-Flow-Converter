package com.model;




import lombok.Data;
import java.util.List;

@Data
public class SwitchCaseInput {
    private String initialization;
    private List<Case> cases;
    private String defaultStatement;

    @Data
    public static class Case {
        private int value;
        private String statement;
    }
}
