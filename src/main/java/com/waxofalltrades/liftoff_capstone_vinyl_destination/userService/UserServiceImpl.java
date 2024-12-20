package com.waxofalltrades.liftoff_capstone_vinyl_destination.userService;

import com.waxofalltrades.liftoff_capstone_vinyl_destination.dto.UserDto;
import com.waxofalltrades.liftoff_capstone_vinyl_destination.models.User;
import com.waxofalltrades.liftoff_capstone_vinyl_destination.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @Override
    public User save(UserDto userDto) {
        User user = new User(userDto.getEmail(), passwordEncoder.encode(userDto.getPassword()), userDto.getRole(), userDto.getFirstName(), userDto.getLastName());
        return userRepository.save(user);
    }
}
