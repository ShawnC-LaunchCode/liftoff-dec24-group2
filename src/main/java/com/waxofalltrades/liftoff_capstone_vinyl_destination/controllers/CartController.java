package com.waxofalltrades.liftoff_capstone_vinyl_destination.controllers;

import com.waxofalltrades.liftoff_capstone_vinyl_destination.models.ShoppingCart;
import com.waxofalltrades.liftoff_capstone_vinyl_destination.repositories.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequiredArgsConstructor
public class CartController {
    @Autowired
    private ItemRepository itemRepository;

@GetMapping("/cart/{id}")
    public String addToCart(@PathVariable int id){
    ShoppingCart.cart.add(itemRepository.findById(id).get());
    return"redirect:/shop";
}

@GetMapping("/cart")
    public String getCart(Model model){
    model.addAttribute("cart", ShoppingCart.cart);
    return "shop/cart-details";
}


}
