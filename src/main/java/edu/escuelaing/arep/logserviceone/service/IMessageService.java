package edu.escuelaing.arep.logserviceone.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import edu.escuelaing.arep.logserviceone.entity.Message;


public interface IMessageService {

    /**
     * Permite agregar un Mensaje a la base de datos
     * @param message el mensaje que se quiere agregar
     * @return el mensaje creado
     */
    Message saveMessage(Message message);

    /**
     * Permite conocer cuantos mensajes hay en la base de datos
     * @return numero de mensajes en database
     */
    int numberOfMessages();

    /**
     * Genera Json con la lista de los ultimos 10 mensajes
     * @return JSON con lista de ultimos 10 mensajes
     * @throws JsonProcessingException
     */
    String getMessages() throws JsonProcessingException;
}
