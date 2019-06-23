package com.example.demo.Sakila.Repositories;

import com.example.demo.Sakila.Entities.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository("actorRepository")
public interface ActorRepository extends JpaRepository<Actor, Serializable> {
}
