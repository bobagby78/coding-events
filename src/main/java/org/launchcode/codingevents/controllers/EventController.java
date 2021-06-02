package org.launchcode.codingevents.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("events")
public class EventController {

    private static List<String> events = new ArrayList<>();

    @RequestMapping(method = RequestMethod.GET)
    public String stlEvents (Model model){
        model.addAttribute("events", events);
        return "events/index";
    }

    @RequestMapping(method = RequestMethod.GET, value = "create")
    public String renderCreateEventForm(){

        return "events/create";
    }

    @RequestMapping(method = RequestMethod.POST, value = "create")
    public String createEvent(@RequestParam String eventName){
        events.add(eventName);
        return "redirect:"; //redirects the user to the root path. can add custom path after :
    }
}
