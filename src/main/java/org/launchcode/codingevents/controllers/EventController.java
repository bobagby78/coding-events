package org.launchcode.codingevents.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("events")
public class EventController {

//    private static List<String> events = new ArrayList<>();
    /*events is an ArrayList of events, so when populated, it would look like this: ["WWDC", "Code with Pride","Raspberry Pi Jam"]
    TODO turn events into a HashMap <String eventName, String eventDescrip>
     */

    private static HashMap<String, String> events = new HashMap<>();


    @RequestMapping(method = RequestMethod.GET)
    public String displayAllEvents(Model model){
//        model.addAttribute("events", events);
//        return "events/index";

        events.put("Ras Pi Jam", "Event revolving around the use of the RasPi SBC");
        events.put("StrangeLoop", "Coding event in St. Louis");
        events.put("WWDC", "Apple's Dev Conference");

        model.addAttribute("events", events); //nothing shows up in allEvents until you model.addAttribute(events);.
        return "events/index";
    }

    @RequestMapping(method = RequestMethod.GET, value = "create")
    public String renderCreateEventForm(){

        return "events/create";
    }

    @RequestMapping(method = RequestMethod.POST, value = "create")
    public String createEvent(@RequestParam String eventName, @RequestParam String eventDescrip){
        events.put(eventName, eventDescrip);
        return "redirect:"; //redirects the user to the root path. can add custom path after :
    }
}
