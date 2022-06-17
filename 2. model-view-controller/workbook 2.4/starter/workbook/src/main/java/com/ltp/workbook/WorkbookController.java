package com.ltp.workbook;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WorkbookController {

    @GetMapping(value="/")
    public String getSign(Model model) {
        model.addAttribute("speed", 45);
        return "sign";
    }
    
}
