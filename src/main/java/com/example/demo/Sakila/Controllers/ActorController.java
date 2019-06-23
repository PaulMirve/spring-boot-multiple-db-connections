package com.example.demo.Sakila.Controllers;

import com.example.demo.Sakila.Entities.Actor;
import com.example.demo.Sakila.Repositories.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ActorController {
    @Autowired
    @Qualifier("actorRepository")
    private ActorRepository actorRepository;

    @GetMapping("/actors")
    public List<Actor> actors(){
        return actorRepository.findAll();
    }
}
