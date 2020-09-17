package edu.escuelaing.arep.logserviceone.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import edu.escuelaing.arep.logserviceone.entity.Message;
import edu.escuelaing.arep.logserviceone.service.IMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/message")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class MessageController {
    @Autowired
    IMessageService messageService;

    @PostMapping("/add")
    public void saveMessage(@RequestBody Message message){
        int id = messageService.numberOfMessages() + 1;
        message.setId(id);
        messageService.saveMessage(message);
    }

    @GetMapping("/get")
    public String getMessages() throws JsonProcessingException {
        return messageService.getMessages();
    }
}
