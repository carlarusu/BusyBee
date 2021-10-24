package com.project.business_layer.services.command;

import com.project.business_layer.entity.User;
import com.project.persistence_layer.repository.UserRepository;
import com.project.presentation_layer.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserCommandService {

    @Autowired
    UserRepository userRepository;


    @Transactional
    public int register(UserDto userDto) {
        if (userRepository.findByUsername(userDto.getUsername()) != null)
            return -1;

        User login = new User();
        login.setUsername(userDto.getUsername());
        login.setPassword(userDto.getPassword());
        userRepository.save(login);
        return 0;
    }

}
