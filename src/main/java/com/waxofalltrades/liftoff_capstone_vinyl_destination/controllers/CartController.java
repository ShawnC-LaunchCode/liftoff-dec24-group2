package com.waxofalltrades.liftoff_capstone_vinyl_destination.controllers;

import com.waxofalltrades.liftoff_capstone_vinyl_destination.models.Item;
import com.waxofalltrades.liftoff_capstone_vinyl_destination.models.ShoppingCart;
import com.waxofalltrades.liftoff_capstone_vinyl_destination.repositories.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class CartController {
    @Autowired
    private ItemRepository itemRepository;

@GetMapping("/cart/{id}")
    public String addToCart(@PathVariable int id, RedirectAttributes redirectAttributes){
    Item item = itemRepository.findById(id).get();
    int albumId = item.getAlbum().getId();
    if (item.getQtyInStock() > 0) {
        ShoppingCart.cart.add(item);
        item.setQtyInStock(item.getQtyInStock() -1);
        itemRepository.save(item);
    }

    redirectAttributes.addAttribute("albumId", albumId);
    return"redirect:/album/inventory/{albumId}";
}

@GetMapping("/cart")
    public String getCart(Model model){
    model.addAttribute("cart", ShoppingCart.cart);
    model.addAttribute("cartCount",ShoppingCart.cart.size());
    double priceTotal = 0;
    for (int i = 0; i < ShoppingCart.cart.size(); i++) {
        priceTotal += ShoppingCart.cart.get(i).getPrice();

    }
    model.addAttribute("total", priceTotal);
    return "shop/cart-details";
}

@GetMapping("/remove/{index}/{id}")
    public String removeItem(@PathVariable int index , @PathVariable int id){
    Item item = itemRepository.findById(id).get();
    ShoppingCart.cart.remove(index);
    item.setQtyInStock(item.getQtyInStock() + 1);
    itemRepository.save(item);
    return "redirect:/cart";
}

@GetMapping("/shop/success")
    public String checkoutSuccess(){
    ShoppingCart.cart.clear();
    return "/shop/paid";
}
    @GetMapping("/shop/cancel")
    public String checkoutCancel(){
        return "/shop/cancel";
    }

    @GetMapping("/cart/checkout")
    public String checkout(){
    if (!ShoppingCart.cart.isEmpty()){
        return"redirect:/checkout";
    }else{
    return"redirect:/cart";
    }
    }

}
