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
        Check itemRepository for matching album, condition, and format values of newItem
        If item exists in database:
            display link to edit existing item
        else:
            add new item
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
    public String processEditItemForm(@RequestParam Integer itemId,
                                      @RequestParam(value = "price") double itemPrice,
                                      @RequestParam(value = "qtyInStock") int itemQty){
        Optional<Item> result = itemRepository.findById(itemId);
        if (result.isEmpty()) {
            return "item/edit";
        } else {
            Item item = result.get();
            item.setPrice(itemPrice);
            item.setQtyInStock(itemQty);
            itemRepository.save(item);
        }
        return "redirect:/item/";
    }

    @PostMapping("delete/{id}")
    public String processDeleteItem(@PathVariable("id") int itemId) {
        itemRepository.deleteById(itemId);
        return "redirect:/item/";
    }



}
