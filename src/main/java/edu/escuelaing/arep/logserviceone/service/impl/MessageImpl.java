package edu.escuelaing.arep.logserviceone.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.escuelaing.arep.logserviceone.entity.Message;
import edu.escuelaing.arep.logserviceone.repository.MessageRepository;
import edu.escuelaing.arep.logserviceone.service.IMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MessageImpl implements IMessageService {
    @Autowired
    MessageRepository messageRepository;

    @Override
    public Message saveMessage(Message message) {
        String[] split = message.getMessage().split("=");
        message.setMessage(split[0]);
        return messageRepository.save(message);
    }

    @Override
    public int numberOfMessages() {
        List<Message> messages = messageRepository.findAll();
        return messages.size();
    }

    @Override
    public String getMessages() throws JsonProcessingException {
        String listOfMessages;
        List<Message> messages = messageRepository.findAll();
        if(messages.size() > 10){
            List<Message> lastMessages = new ArrayList<>();
            int position = messages.size() - 10;
            for(int x = position; x < messages.size(); x++){
                lastMessages.add(messages.get(x));
            }
            listOfMessages = new ObjectMapper().writeValueAsString(lastMessages);
        } else {
            listOfMessages = new ObjectMapper().writeValueAsString(messages);
        }
        return listOfMessages;
    }
}
