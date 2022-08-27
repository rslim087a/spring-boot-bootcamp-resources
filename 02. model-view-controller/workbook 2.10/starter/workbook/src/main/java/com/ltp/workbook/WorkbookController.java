package com.ltp.workbook;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class WorkbookController {

    
    @GetMapping(value="/")
    public String getStaff(Model model) {
        return "staff";
    }
    
}
