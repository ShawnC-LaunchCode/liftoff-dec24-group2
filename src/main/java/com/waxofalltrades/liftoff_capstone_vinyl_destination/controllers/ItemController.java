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
    public String processAddItemForm(@Valid @ModelAttribute("data") Item newItem,
                                     Errors errors, Model model){


        try {
            if (errors.hasErrors()) {
                model.addAttribute(new Item());
                model.addAttribute("errorMsg", "Error: Ensure Selection Made for All Fields and Price is Greater than 0");
                model.addAttribute("albums", albumRepository.findAll());
                model.addAttribute("conditionTypes", conditionTypeRepository.findAll());
                model.addAttribute("formatTypes", formatTypeRepository.findAll());
                return "item/add";
            }
            newItem.setSku(newItem.getSku());
            itemRepository.save(newItem);
        }

        catch (DataIntegrityViolationException e){
            model.addAttribute("errorMsg", "Item already in inventory");
            model.addAttribute(new Item());
            model.addAttribute("albums", albumRepository.findAll());
            model.addAttribute("conditionTypes", conditionTypeRepository.findAll());
            model.addAttribute("formatTypes", formatTypeRepository.findAll());
            return "item/add";
        }

        return "redirect:/album/inventory/" + newItem.getAlbum().getId();
    }

    @GetMapping("edit/{itemId}")
    public String displayEditItemForm(@PathVariable int itemId, Model model){
        Optional<Item> result = itemRepository.findById(itemId);

        if (result.isEmpty()) {
            model.addAttribute("heading", "Invalid Item ID: " + itemId);
        } else {
            Item item = result.get();
            model.addAttribute("heading", "Modify Item: " + item.getAlbum().getName() + " (ID: " + item.getId() + ")");
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
            return "redirect:/album/";
        } else {
            Item item = result.get();
            item.setPrice(itemPrice);
            item.setQtyInStock(itemQty);
            itemRepository.save(item);
        }
        return "redirect:/album/inventory/" + result.get().getAlbum().getId();
    }

    @PostMapping("delete/{id}")
    public String processDeleteItem(@PathVariable("id") int itemId) {
        Optional<Item> result = itemRepository.findById(itemId);
        if (result.isEmpty()) {
            return "redirect:/album/";
        } else {
            itemRepository.deleteById(itemId);
        }
        return "redirect:/album/inventory/" + result.get().getAlbum().getId();
    }



}
