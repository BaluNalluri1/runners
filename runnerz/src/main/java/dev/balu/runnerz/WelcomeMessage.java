package dev.balu.runnerz;

import org.springframework.stereotype.Component;

import java.sql.SQLOutput;


@Component
public class WelcomeMessage {

    public String getWelcomeMessage(){
        return "Welcome to Spring-boot App";
    }
}
