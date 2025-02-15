package com.waxofalltrades.liftoff_capstone_vinyl_destination.repositories;

import com.waxofalltrades.liftoff_capstone_vinyl_destination.models.Event;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepository extends CrudRepository<Event, Integer> {
    public List<Event> findAllByOrderByEventDateAsc();
}
