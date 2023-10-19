package com.library.core.api.mailsender;

import com.library.core.model.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface MailSender {

    public String send(List<User> users, String message);
}
