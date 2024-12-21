package com.waxofalltrades.liftoff_capstone_vinyl_destination.repositories;

import com.waxofalltrades.liftoff_capstone_vinyl_destination.models.FormatType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FormatTypeRepository extends CrudRepository<FormatType, Integer> {
}
