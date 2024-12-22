package com.waxofalltrades.liftoff_capstone_vinyl_destination.controllers;

import com.waxofalltrades.liftoff_capstone_vinyl_destination.dto.ItemConditionTypeDTO;
import com.waxofalltrades.liftoff_capstone_vinyl_destination.models.ConditionType;
import com.waxofalltrades.liftoff_capstone_vinyl_destination.models.Item;
import com.waxofalltrades.liftoff_capstone_vinyl_destination.repositories.AlbumRepository;
import com.waxofalltrades.liftoff_capstone_vinyl_destination.repositories.ConditionTypeRepository;
import com.waxofalltrades.liftoff_capstone_vinyl_destination.repositories.FormatTypeRepository;
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
@RequestMapping(value = "item")
public class ItemController {

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private AlbumRepository albumRepository;

    @Autowired
    private ConditionTypeRepository conditionTypeRepository;

    @Autowired
    private FormatTypeRepository formatTypeRepository;

    @RequestMapping("/")
    public String displayItems(Model model){
         model.addAttribute("items", itemRepository.findAll());

         return "item/result";
    }

    @GetMapping("add")
    public String displayAddItemForm(Model model){
        model.addAttribute(new Item());
        model.addAttribute("albums", albumRepository.findAll());
        model.addAttribute("conditionTypes", conditionTypeRepository.findAll());
        model.addAttribute("formatTypes", formatTypeRepository.findAll());

        return "item/add";
    }

    @PostMapping("add")
    public String processAddItemForm(@ModelAttribute @Valid Item newItem,
                                     Errors errors, Model model){
        if(errors.hasErrors()) {
            return "item/add";
        }

        // If item with same albumId, conditionType, formatType exists in itemRepository:
            // Increment item.qtyInStock by 1

        // else:
            // Create new item

        itemRepository.save(newItem);
        return "redirect:/item/";
    }



}
