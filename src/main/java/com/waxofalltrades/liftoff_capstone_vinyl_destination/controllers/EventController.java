package com.waxofalltrades.liftoff_capstone_vinyl_destination.controllers;

import com.waxofalltrades.liftoff_capstone_vinyl_destination.repositories.EventRepository;
import com.waxofalltrades.liftoff_capstone_vinyl_destination.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "event")
public class EventController {

    @Autowired
    private EventRepository eventRepository;

    // Display all Events
    @RequestMapping("/")
    public String displayAllEvents(Model model){
        model.addAttribute("events", eventRepository.findAll());

        return "event/list";
    }

    // Add Event

    // Modify Event

    // Delete Event

    // Show Event Details
}
