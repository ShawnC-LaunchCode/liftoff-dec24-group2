package com.waxofalltrades.liftoff_capstone_vinyl_destination.controllers;

import com.waxofalltrades.liftoff_capstone_vinyl_destination.models.EventType;
import com.waxofalltrades.liftoff_capstone_vinyl_destination.repositories.EventTypeRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping(value = "EventType")
public class EventTypeController {


    @Autowired
    EventTypeRepository eventTypeRepository;

    @RequestMapping("/")
    public String displayEventTypes(Model model) {
        model.addAttribute("eventTypes", eventTypeRepository.findAllByOrderByNameAsc());
        return "eventType/list";
    }

    @GetMapping("add")
    public String displayAddGenreForm(Model model) {
        model.addAttribute(new EventType());

        return "eventType/add";
    }

    @PostMapping("add")
    public String processAddEventTypeForm(@ModelAttribute @Valid EventType newEventType, Errors errors) {
        if (errors.hasErrors()) {
            return "eventType/add";
        }

        eventTypeRepository.save(newEventType);

        return "redirect:/EventType/";
    }

    @GetMapping("edit/{id}")
    public String displayEditEventTypeForm(@PathVariable int id, Model model) {
        Optional<EventType> result = eventTypeRepository.findById(id);

        if (result.isEmpty()) {
            model.addAttribute("heading", "No Event Type Found for ID: " + id);
        } else {
            EventType eventType = result.get();
            model.addAttribute("heading", "Modify Event: " + eventType.getName());
            model.addAttribute("eventType", eventType);
        }
        return "eventType/edit";
    }

    @PostMapping("edit")
    public String processEditEventTypeForm(@RequestParam Integer eventTypeId,
                                           @RequestParam(value = "name") String eventTypeName) {
        Optional<EventType> result = eventTypeRepository.findById(eventTypeId);
        if (result.isEmpty()) {
            return "redirect:/EventType/";
        }

        EventType eventType = result.get();
        eventType.setName(eventTypeName);
        eventTypeRepository.save(eventType);

        return "redirect:/EventType/";
    }

    @PostMapping("delete/{id}")
    public String processEditGenreForm(@PathVariable("id") int id) {
        eventTypeRepository.deleteById(id);

        return "redirect:/EventType/";
    }


}
