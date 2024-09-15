package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.model.ComplexIfElseLoopInput;
import com.model.ComplexLoopInput;
import com.model.IfElseInput;
import com.model.LoopInput;
import com.model.NestedIfElseInput;

import com.model.SwitchCaseInput;
import com.service.FlowDiagramService;

@RestController
@RequestMapping("/api/flow")
public class FlowDiagramController {

    @Autowired
    private FlowDiagramService flowDiagramService;

    @PostMapping("/if-else")
    public String convertIfElse(@RequestBody IfElseInput input) {
        return flowDiagramService.convertIfElse(input);
    }

    @PostMapping("/nested-if-else")
    public String convertNestedIfElse(@RequestBody NestedIfElseInput input) {
        return flowDiagramService.convertNestedIfElse(input);
    }

    @PostMapping("/loop")
    public String convertLoop(@RequestBody LoopInput input) {
        return flowDiagramService.convertLoop(input);
    }

    @PostMapping("/multiple-nested-loop")
    public String convertMultipleNestedLoop(@RequestBody LoopInput input) {
        return flowDiagramService.convertMultipleNestedLoop(input);
    }
    
	/*
	 * @PostMapping("/nested-loop") public String convertNestedLoop(@RequestBody
	 * NestedLoopInput input) { return flowDiagramService.convertNestedLoop(input);
	 * }
	 */

    @PostMapping("/switch-case")
    public String convertSwitchCase(@RequestBody SwitchCaseInput input) {
        return flowDiagramService.convertSwitchCase(input);
    }
    
    @PostMapping("/complex-loop")
    public String convertComplexLoop(@RequestBody ComplexLoopInput input) {
        return flowDiagramService.convertComplexLoop(input);
    }
    
    @PostMapping("/complex-if-else-loop")
    public String convertComplexIfElseLoop(@RequestBody ComplexIfElseLoopInput input) {
        return flowDiagramService.convertComplexIfElseLoop(input);
    }
    
    
}