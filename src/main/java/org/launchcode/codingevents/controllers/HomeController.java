package org.launchcode.codingevents.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
public class HomeController {

    @RequestMapping(method = RequestMethod.GET, value = "index")
    public String index(){
        return "index";
    }


}
