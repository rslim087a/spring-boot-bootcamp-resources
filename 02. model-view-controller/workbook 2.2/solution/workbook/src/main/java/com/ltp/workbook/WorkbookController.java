package com.ltp.workbook;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WorkbookController {
    
    @GetMapping("/")
    public ModelAndView getShows() {
        Map<String, Show> model = new HashMap<String, Show>();
        model.put("first", new Show("Breaking Bad", "Ozymandias", 10.0));
        model.put("second", new Show("Attack on Titan", "Perfect Game", 9.9));
        model.put("third", new Show("Attack on Titan", "Perfect Game", 9.9));
        model.put("fourth", new Show("Star Wars: The Clone Wars", "Victory and Death", 	9.9));
        model.put("fifth", new Show("Mr. Robot", "407 Proxy Authentication Required", 9.9));
        return new ModelAndView("shows", model);
    }

}
