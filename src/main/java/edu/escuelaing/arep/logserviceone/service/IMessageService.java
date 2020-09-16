package edu.escuelaing.arep.logserviceone.service;

import edu.escuelaing.arep.logserviceone.entity.Message;

public interface IMessageService {

    Message saveMessage(Message message);

    int numberOfMessages();
}
