package org.launchcode.codingevents.controllers;

import org.launchcode.codingevents.data.EventData;
import org.launchcode.codingevents.models.Event;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
     eventName, String eventDescrip>
     */

    //    private static HashMap<String, String> events = new HashMap<>();

    @RequestMapping(method = RequestMethod.GET)
    public String displayAllEvents(Model model) {
        model.addAttribute("events", EventData.getAll());
        return "events/index";
    }

    @RequestMapping(method = RequestMethod.GET, value = "create")
    public String renderCreateEventForm() {

        return "events/create";
    }

    @RequestMapping(method = RequestMethod.POST, value = "create")
    public String createEvent(@RequestParam String eventName, @RequestParam String eventDescription) {
        EventData.add(new Event(eventName, eventDescription)); //had to change due to importing Event (object), not string
        return "redirect:"; //redirects the user to the root path. can add custom path after :
    }

    @RequestMapping(method = RequestMethod.GET, value = "delete")
    public String displayDeleteEventForm(Model model){
        model.addAttribute("title", "Delete Events");
        model.addAttribute("events", EventData.getAll());
        return "events/delete";
    }

    @RequestMapping(method = RequestMethod.POST, value = "delete")
    public String processDeleteEventsForm(@RequestParam(required = false) int[] eventIds){
        if(eventIds != null) {
            for (int id : eventIds) {
                EventData.remove(id);
            }
        }
        return "redirect:";
    }

//    @RequestMapping(method = RequestMethod.POST, value = "create")
//    public String createEvent(@RequestParam String eventName, @RequestParam String eventDescrip) {
//        events.put(eventName, eventDescrip);
//        return "redirect:"; //redirects the user to the root path. can add custom path after :
//    }
}
