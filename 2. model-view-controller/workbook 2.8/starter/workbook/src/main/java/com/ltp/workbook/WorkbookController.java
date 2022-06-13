package com.ltp.workbook;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class WorkbookController {
    @GetMapping(value="/")
    public String getLandingPage() {
        return "page";
    }
    
}
