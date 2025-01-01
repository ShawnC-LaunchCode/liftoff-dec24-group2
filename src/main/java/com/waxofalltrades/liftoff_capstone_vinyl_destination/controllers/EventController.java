package com.waxofalltrades.liftoff_capstone_vinyl_destination.controllers;

import com.waxofalltrades.liftoff_capstone_vinyl_destination.models.Event;
import com.waxofalltrades.liftoff_capstone_vinyl_destination.models.Item;
import com.waxofalltrades.liftoff_capstone_vinyl_destination.repositories.EventRepository;
import com.waxofalltrades.liftoff_capstone_vinyl_destination.repositories.EventTypeRepository;
import com.waxofalltrades.liftoff_capstone_vinyl_destination.repositories.ItemRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "event")
public class EventController {

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private EventTypeRepository eventTypeRepository;

    // Display all Events
    @RequestMapping("/")
    public String displayAllEvents(Model model){
        model.addAttribute("events", eventRepository.findAll());

        return "event/list";
    }


    // Add Event
    @GetMapping("add")
    public String displayAddEventForm(Model model){
        model.addAttribute(new Event());
        model.addAttribute("eventTypes", eventTypeRepository.findAll());
        return "event/add";
    }

    @PostMapping("add")
    public String processAddEventForm(@ModelAttribute @Valid Event newEvent,
                                      Errors errors, Model model){

        if (errors.hasErrors()) {
            model.addAttribute(new Event());
            model.addAttribute("eventTypes", eventTypeRepository.findAll());
            return "event/add";
        }
        else {
            eventRepository.save(newEvent);
        }
        return "redirect:/event/";
    }

    // Modify Event

    // Delete Event

    // Show Event Details
}
