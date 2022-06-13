package com.ltp.workbook;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WorkbookController {
    
    @GetMapping("/")
    public String getName(Model model) {
        model.addAttribute("name", "Rayan");
        return "name-list";
    }
}
