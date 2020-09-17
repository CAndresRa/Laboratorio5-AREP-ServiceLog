package edu.escuelaing.arep.logserviceone.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import edu.escuelaing.arep.logserviceone.entity.Message;


public interface IMessageService {

    Message saveMessage(Message message);

    int numberOfMessages();

    String getMessages() throws JsonProcessingException;
}
