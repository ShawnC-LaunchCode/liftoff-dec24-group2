package com.waxofalltrades.liftoff_capstone_vinyl_destination.repositories;

import com.waxofalltrades.liftoff_capstone_vinyl_destination.models.User;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Id> {

    User findByEmail (String email);
}
