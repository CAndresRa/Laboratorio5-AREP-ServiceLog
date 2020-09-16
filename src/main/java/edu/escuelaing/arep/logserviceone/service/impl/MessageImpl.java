package edu.escuelaing.arep.logserviceone.service.impl;

import edu.escuelaing.arep.logserviceone.entity.Message;
import edu.escuelaing.arep.logserviceone.repository.MessageRepository;
import edu.escuelaing.arep.logserviceone.service.IMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageImpl implements IMessageService {
    @Autowired
    MessageRepository messageRepository;

    @Override
    public Message saveMessage(Message message) {
        return messageRepository.save(message);
    }

    @Override
    public int numberOfMessages() {
        List<Message> messages = messageRepository.findAll();
        return messages.size();
    }
}
