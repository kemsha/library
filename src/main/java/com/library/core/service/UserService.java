package com.library.core.service;

import com.library.core.api.mailsender.MailSender;
import com.library.core.exceptions.repository.ResourceNotFoundException;
import com.library.core.model.User;
import com.library.core.repository.UserRepository;
import com.library.rest.dto.UserDTO;
import com.library.rest.dto.UserRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private MailSender mailgunSender;

    @Autowired
    private MailSender sendgridSender;
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public String sendEmailToAllUsers(String message) {
        List<User> users = userRepository.findAll();

        return mailgunSender.send(users,message);
    }

    public List<UserDTO> getUsers() {
        List<User> users = userRepository.findAll();

        return users.stream().map(UserDTO::new).collect(Collectors.toList());
    }

    public UserDTO getUserById(String id){
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty()) {
            throw new ResourceNotFoundException("The user with given ID does not exist.");
        }
        return new UserDTO(user.get());
    }

    public UserDTO addUser(UserRequestDTO payload) {
        User user = userRepository.save(payload.toEntity());
        return new UserDTO(user);
    }
}
