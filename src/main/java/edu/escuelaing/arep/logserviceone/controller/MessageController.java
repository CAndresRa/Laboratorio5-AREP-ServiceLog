package edu.escuelaing.arep.logserviceone.controller;

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
        System.out.println("LLEGOOOOO");
        int id = messageService.numberOfMessages() + 1;
        message.setId(id);
        messageService.saveMessage(message);
    }
}
