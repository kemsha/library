package com.library.core.service;

import com.library.core.api.mailsender.MailSender;
import com.library.core.exceptions.repository.ResourceNotFoundException;
import com.library.core.model.User;
import com.library.core.repository.UserRepository;
import com.library.rest.dto.UserDTO;
import com.library.rest.dto.UserRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
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

    public UserDTO updateUser(String id, UserRequestDTO payload){
        Optional<User> user = userRepository.findById(id);

        if(user.isEmpty()){
            throw new ResourceNotFoundException("The user with given ID does not exist.");
        }
        User updatedUser = payload.toEntity();
        updatedUser.setId(user.get().getId());
        updatedUser = userRepository.save(updatedUser);
        return new UserDTO(updatedUser);
    }

    public void deleteUser(String id) {
        Optional<User> user = userRepository.findById(id);
        user.ifPresent(userRepository::delete);
    }

    public UserDTO filterByUserName(String username) {
        Optional<User> user = userRepository.findByUsername(username);

        return user.map(UserDTO::new).orElse(null);
    }

    public UserDetailsService userDetailsService() {
        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
                return userRepository.findByUsernameOrEmail(username).orElseThrow( () -> new UsernameNotFoundException("User not found"));
            }
        };
    }
}
