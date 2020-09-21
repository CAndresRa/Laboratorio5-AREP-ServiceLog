package edu.escuelaing.arep.logserviceone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Collections;

@SpringBootApplication
public class LogserviceoneApplication {

    /**
     * Servicio que permite almacenar y obtener mensajes.
     * @param args n/a
     */
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(LogserviceoneApplication.class);
        app.setDefaultProperties(Collections.singletonMap("server.port", getPort()));
        app.run(args);
    }

    /**
     * Optiene puerto del entorno.
     * @return port del entorno
     */
    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 35000; //returns default port if heroku-port isn't set (i.e. on localhost)
    }
}
