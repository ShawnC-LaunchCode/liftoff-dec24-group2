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
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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
        /*
        -- Error Handling
        if (errors.hasErrors()) {
            model.addAttribute(new Event());
            model.addAttribute("eventTypes", eventTypeRepository.findAll());
            return "event/add";
        }
        */



        eventRepository.save(newEvent);

        return "redirect:/event/";
    }

    // Modify Event
    @GetMapping("edit")
    public String displayEditEventForm(@RequestParam Integer eventId, Model model){
        Optional<Event> result = eventRepository.findById(eventId);

        if (result.isEmpty()) {
            model.addAttribute("heading", "Invalid Event ID: " + eventId);
        } else {
            Event event = result.get();
            model.addAttribute("heading", "Modify Event: " + eventId);
            model.addAttribute("event", event);
            model.addAttribute("eventTypes", eventTypeRepository.findAll());
        }

        return "event/edit";
    }


    // Delete Event

    // Show Event Details
}
