package com.waxofalltrades.liftoff_capstone_vinyl_destination.userService;

import com.waxofalltrades.liftoff_capstone_vinyl_destination.models.Item;
import com.waxofalltrades.liftoff_capstone_vinyl_destination.repositories.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ItemService {

    private ItemRepository itemRepository;

    public Iterable<Item> getAllItems(){
        return itemRepository.findAll();
    }

    public void deleteItemById(int id) {
        itemRepository.deleteById(id);
    }

    public Optional<Item> getItemById(int id) {
        return itemRepository.findById(id);
    }


    public void addItem(Item item) {
        itemRepository.save(item);
    }

}
