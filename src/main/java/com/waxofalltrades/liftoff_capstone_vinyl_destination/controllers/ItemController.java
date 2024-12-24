package com.waxofalltrades.liftoff_capstone_vinyl_destination.controllers;

import com.waxofalltrades.liftoff_capstone_vinyl_destination.dto.ItemConditionTypeDTO;
import com.waxofalltrades.liftoff_capstone_vinyl_destination.models.*;
import com.waxofalltrades.liftoff_capstone_vinyl_destination.repositories.AlbumRepository;
import com.waxofalltrades.liftoff_capstone_vinyl_destination.repositories.ConditionTypeRepository;
import com.waxofalltrades.liftoff_capstone_vinyl_destination.repositories.FormatTypeRepository;
import com.waxofalltrades.liftoff_capstone_vinyl_destination.repositories.ItemRepository;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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
                                     Errors errors){

        try {
            if (errors.hasErrors()) {
                return "item/add";
            }

        /*
        // If item with same albumId, conditionType, formatType exists in itemRepository:
            // Increment item.qtyInStock by 1
        Album albumLookup = newItem.getAlbum();
        ConditionType conditionTypeLookup = newItem.getConditionType();
        FormatType formatTypeLookup = newItem.getFormatType();
        Item existingItem = itemRepository.findByAlbumConditionFormat(albumLookup, conditionTypeLookup, formatTypeLookup);
        if(existingItem != null){
            // if existing item in database, inform user item exists
            // redirect to item detail page?
            existingItem.setQtyInStock(existingItem.getQtyInStock() + 1);
        }
        else{
            // save new item
            itemRepository.save(newItem);
        }
       */
            itemRepository.save(newItem);
        }

        catch (DataIntegrityViolationException e){
            return "redirect:/item/";
        }

        return "redirect:/item/";
    }

    @GetMapping("edit")
    public String displayEditItemForm(@RequestParam Integer itemId, Model model){
        Optional<Item> result = itemRepository.findById(itemId);

        if (result.isEmpty()) {
            model.addAttribute("heading", "Invalid Event ID: " + itemId);
        } else {
            Item item = result.get();
            model.addAttribute("heading", "Modify Item: " + itemId);
            model.addAttribute("item", item);
        }

        return "item/edit";
        }

    @PostMapping("edit")
    public String processEditItemForm(@ModelAttribute @Valid Item existingItem, Errors errors){
        if(errors.hasErrors()) {
            return "item/edit";
        }

        itemRepository.save(existingItem);

        return "redirect:/item/";
    }



}
