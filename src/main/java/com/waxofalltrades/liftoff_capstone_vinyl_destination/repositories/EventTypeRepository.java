package com.waxofalltrades.liftoff_capstone_vinyl_destination.repositories;

import com.waxofalltrades.liftoff_capstone_vinyl_destination.models.Artist;
import com.waxofalltrades.liftoff_capstone_vinyl_destination.models.EventType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventTypeRepository extends CrudRepository<EventType, Integer> {
    List<EventType> findAllByOrderByNameAsc();
}
