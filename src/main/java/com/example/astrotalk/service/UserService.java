package com.example.astrotalk.service;

import com.example.astrotalk.dto.SignupUserDto;
import com.example.astrotalk.dto.UserDto;
import com.example.astrotalk.entity.User;
import com.example.astrotalk.exception.UserAlreadyExists;
import com.example.astrotalk.repository.UserRepository;
import com.example.astrotalk.userDetail.HospitalUserDetails;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user=userRepository.findByEmail(email).orElseThrow(()->new UserAlreadyExists("User Not Found"));
        return new HospitalUserDetails(user);
    }


    public ResponseEntity<UserDto> CreateUser(SignupUserDto signupUserDto) {
        User newUser;
        UserDto userDto = null;
        Optional<User> user = userRepository.findByEmail(signupUserDto.getEmail());
        if (!user.isPresent()) {
            newUser = modelMapper.map(signupUserDto, User.class);
            newUser.setRole("admin");
            newUser.setActive(true);
            userRepository.save(newUser);
            userDto=modelMapper.map(newUser,UserDto.class);
        }
        else{
            throw new UserAlreadyExists("user already exists");
        }
        return ResponseEntity.ok(userDto);
    }

}
