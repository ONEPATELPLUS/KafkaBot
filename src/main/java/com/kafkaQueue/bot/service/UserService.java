package com.kafkaQueue.bot.service;

import com.kafkaQueue.bot.entity.Messages;
import com.kafkaQueue.bot.entity.User;
import com.kafkaQueue.bot.repository.MessageRepo;
import com.kafkaQueue.bot.repository.UserDetailsRepo;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {

    @Autowired
    UserDetailsRepo userDetailsRepo;

    @Autowired
    MessageRepo messageRepo;

    public void saveUserDetails(Long userNumber, Long messageId,String message){
        User user = userDetailsRepo.findUserNumber(userNumber);

        Messages messages = new Messages();

        if (user == null) {
            User newUser = new User();
            newUser.setUserNumber(userNumber);
            newUser.setDate(new Date());
            userDetailsRepo.save(newUser);
            messages.setUser(newUser);
        }else{
            messages.setUser(user);
        }
        messages.setMessageId(messageId);
        messages.setMessage(message);

        messageRepo.save(messages);
    }

    public void updateUserDetails(Long userNumber ,Long messageId, String message){
        User user = userDetailsRepo.findUserNumber(userNumber);
        Messages messages = messageRepo.findByMessageIdAndUser(messageId, user);
        messages.setMessage(message);
        messageRepo.save(messages);
    }
}
