package com.waxofalltrades.liftoff_capstone_vinyl_destination.controllers;

import com.waxofalltrades.liftoff_capstone_vinyl_destination.models.Item;
import com.waxofalltrades.liftoff_capstone_vinyl_destination.models.ShoppingCart;
import com.waxofalltrades.liftoff_capstone_vinyl_destination.repositories.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class CartController {
    @Autowired
    private ItemRepository itemRepository;

@GetMapping("/cart/{id}")
    public String addToCart(@PathVariable int id){
    Item item = itemRepository.findById(id).get();
    if (item.getQtyInStock() > 0) {
        ShoppingCart.cart.add(item);
        item.setQtyInStock(item.getQtyInStock() -1);
        itemRepository.save(item);
    }
    return"redirect:/shop";
}

@GetMapping("/cart")
    public String getCart(Model model){
    model.addAttribute("cart", ShoppingCart.cart);
    return "shop/cart-details";
}

@GetMapping("/remove/{index}")
    public String removeItem(@PathVariable int index){
    Item item = ShoppingCart.cart.get(index);
    ShoppingCart.cart.remove(item);
    item.setQtyInStock(item.getQtyInStock() + 1);
    itemRepository.save(item);
    return "redirect:/cart";
}

@GetMapping("/shop/success")
    public String checkoutSuccess(){
    ShoppingCart.cart.clear();
    return "/shop/paid";
}

}
