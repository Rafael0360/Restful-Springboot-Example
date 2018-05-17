package br.rafael.example.webservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;

@SpringBootApplication
@ComponentScan(value = "br.rafael.example.webservice")
public class Main {

    public static void main(String[] args){
        SpringApplication.run(Main.class, args);
    }
}
