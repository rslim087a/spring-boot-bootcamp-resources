package com.ltp.conditionals;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class ConditionalsController {

    @GetMapping(value="/")
    public String getMethodName() {
        return "conditionals";
    }
    
}
