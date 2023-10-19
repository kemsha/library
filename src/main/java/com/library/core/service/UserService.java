package com.library.core.service;

import com.library.core.api.mailsender.MailSender;
import com.library.core.model.User;
import com.library.core.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
