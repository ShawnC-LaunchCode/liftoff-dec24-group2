package com.waxofalltrades.liftoff_capstone_vinyl_destination.repositories;

import com.waxofalltrades.liftoff_capstone_vinyl_destination.models.Genre;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenreRepository extends CrudRepository<Genre, Integer> {
}
