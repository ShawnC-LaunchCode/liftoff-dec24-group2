package com.waxofalltrades.liftoff_capstone_vinyl_destination.controllers;

import com.waxofalltrades.liftoff_capstone_vinyl_destination.models.Event;
import com.waxofalltrades.liftoff_capstone_vinyl_destination.models.EventType;
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

import java.time.LocalDate;
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
    public String displayAllEvents(Model model) {
        model.addAttribute("events", eventRepository.findAll());

        return "event/list";
    }


    // Add Event
    @GetMapping("add")
    public String displayAddEventForm(Model model) {
        model.addAttribute(new Event());
        model.addAttribute("eventTypes", eventTypeRepository.findAll());
        return "event/add";
    }

    @PostMapping("add")
    public String processAddEventForm(@ModelAttribute @Valid Event newEvent,
                                      Errors errors, Model model) {
        /*
        if (errors.hasErrors()) {
            model.addAttribute("heading", "Create Event");
            model.addAttribute("eventTypes", eventTypeRepository.findAll());
            return "event/add";
        }
        */

        eventRepository.save(newEvent);

        return "redirect:/event/";
    }

    // Modify Event
    @GetMapping("edit/{eventId}")
    public String displayEditEventForm(Model model, @PathVariable int eventId) {
        Optional<Event> currentEvent = eventRepository.findById(eventId);

        if (currentEvent.isEmpty()) {
            model.addAttribute("heading", "Invalid Event ID: " + eventId);
        } else {
            Event event = currentEvent.get();
            model.addAttribute("heading", "Modify Event Name: " + event.getName() + " (ID: " + event.getId() + ")");
            model.addAttribute("event", event);
            model.addAttribute("eventTypes", eventTypeRepository.findAll());
        }

        return "event/edit";
    }

    @PostMapping("edit")
    public String processEditEventForm(@RequestParam Integer eventId,
                                       @RequestParam(value = "name") String eventName,
                                       @RequestParam(value = "description") String eventDescription,
                                       @RequestParam(value = "eventDate") LocalDate eventDate,
                                       @RequestParam(value = "eventType") EventType eventType) {
        Optional<Event> currentEvent = eventRepository.findById(eventId);
        if (currentEvent.isEmpty()) {
            return "redirect:/event/";
        }

        Event event = currentEvent.get();
        // event.setEventType(eventType); // Error: Required parameter 'eventType' is not present.
        event.setName(eventName);
        event.setDescription(eventDescription);
        event.setEventDate(eventDate);
        eventRepository.save(event);

        return "redirect:/event/";
    }

    // Delete Event

    // Show Event Details
}
