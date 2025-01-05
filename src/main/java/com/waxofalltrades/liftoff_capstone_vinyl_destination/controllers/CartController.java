package com.waxofalltrades.liftoff_capstone_vinyl_destination.controllers;

import com.waxofalltrades.liftoff_capstone_vinyl_destination.models.ShoppingCart;
import com.waxofalltrades.liftoff_capstone_vinyl_destination.userService.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequiredArgsConstructor
public class CartController {
    private final ItemService itemService;

    @GetMapping("/cart/{id}")
    public String addToCart (@PathVariable int id){
        ShoppingCart.cart.add(itemService.getItemById(id).get());

        return "redirect:/shop/details";

    }


}
