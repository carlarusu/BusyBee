package com.project.business_layer.services.query;

import com.project.business_layer.entity.User;
import com.project.persistence_layer.repository.UserRepository;
import com.project.presentation_layer.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserQueryService {

    @Autowired
    UserRepository userRepository;

    public Integer login(UserDto userDto) {
        User login = userRepository.findByUsername(userDto.getUsername());
        if (login != null)
            if (login.getPassword().equals(userDto.getPassword()))
                return login.getId();
        return null;
    }

    /*public void logout(Integer id) {
    }

    public LoginDto findById(int id) {
        Login login = loginRepository.findById(id);
        LoginDto loginDto = new LoginDto();
        loginDto.setUsername(login.getUsername());
        loginDto.setPassword(login.getPassword());
        loginDto.setGoal(login.getGoal());
        return loginDto;
    }*/
}
