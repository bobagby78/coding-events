package org.launchcode.codingevents.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("events")
public class EventController {

    @RequestMapping(method = RequestMethod.GET)
    public String stlEvents (Model model){
        List<String> events = new ArrayList<>();
        events.add("SLSC First Friday");
        events.add("Code with Pride");
        events.add("Strange Loop");
        events.add("Apple WWDC");

        model.addAttribute("events", events);
        return "events/index";
    }

    @RequestMapping(method = RequestMethod.GET, value = "create")
    public String renderCreateEventForm(){

        return "events/create";
    }
}
