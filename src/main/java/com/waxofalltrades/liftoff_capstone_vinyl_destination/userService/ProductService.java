package com.waxofalltrades.liftoff_capstone_vinyl_destination.userService;

import com.waxofalltrades.liftoff_capstone_vinyl_destination.models.Item;
import com.waxofalltrades.liftoff_capstone_vinyl_destination.repositories.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ItemRepository itemRepository;

    public List<Item> getAllItems(){
        return (List<Item>) itemRepository.findAll();
    }

    public void deleteItemtById(int id) {
        itemRepository.deleteById(id);
    }

    public Optional<Item> getProductById(int id) {
        return itemRepository.findById(id);
    }


    public void addProduct(Item item) {
        itemRepository.save(item);
    }

}
