package com.waxofalltrades.liftoff_capstone_vinyl_destination.repositories;

import com.waxofalltrades.liftoff_capstone_vinyl_destination.models.Album;
import com.waxofalltrades.liftoff_capstone_vinyl_destination.models.Item;
import com.waxofalltrades.liftoff_capstone_vinyl_destination.models.ItemId;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends CrudRepository<Item, Integer> {
    Item findByItemId(ItemId itemId);
}

