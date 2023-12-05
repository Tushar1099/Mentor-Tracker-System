package com.example.userservice.service.serviceImpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

import com.example.userservice.dto.UserDto;
import com.example.userservice.entity.User;
import com.example.userservice.exception.ResourceNotFoundException;
import com.example.userservice.repository.UserRepository;
import com.example.userservice.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public UserDto createUser(UserDto userDto) {
        User user = modelMapper.map(userDto, User.class);
        User createdUser = userRepository.save(user);
        return modelMapper.map(createdUser, UserDto.class);
    }

    @Override
    public UserDto getUserById(int id) {
        Optional<User> userOptional = userRepository.findById(id);
        
        if (userOptional.isPresent()) {
            UserDto userDto = modelMapper.map(userOptional.get(), UserDto.class);
            return userDto;
        } else {
            throw new ResourceNotFoundException("User", "id", id);
        }
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(user -> modelMapper.map(user, UserDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public UserDto updateUser(UserDto user) {
        Optional<User> userOptional = userRepository.findById(user.getId());
        
        if (userOptional.isPresent()) {
            User existingUser = userOptional.get();
            existingUser.setName(user.getName());
            existingUser.setEmail(user.getEmail());
            existingUser.setUserRole(user.getUserRole());
            
            User updatedUser = userRepository.save(existingUser);
            return modelMapper.map(updatedUser, UserDto.class);
        } else {
        	throw new ResourceNotFoundException("User", "id", user.getId());
        }
    }

    @Override
    public void deleteUser(int id) {
        userRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("User", "id", id));
        userRepository.deleteById(id);
    }
}
