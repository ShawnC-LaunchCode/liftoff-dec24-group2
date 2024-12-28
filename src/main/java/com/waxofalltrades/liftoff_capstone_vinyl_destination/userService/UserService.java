package com.waxofalltrades.liftoff_capstone_vinyl_destination.userService;

import com.waxofalltrades.liftoff_capstone_vinyl_destination.dto.UserDto;
import com.waxofalltrades.liftoff_capstone_vinyl_destination.models.User;

public interface UserService {
    User save (UserDto userDto);
}
