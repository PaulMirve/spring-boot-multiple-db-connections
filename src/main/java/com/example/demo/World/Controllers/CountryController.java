package com.example.demo.World.Controllers;

import com.example.demo.World.Entities.Country;
import com.example.demo.World.Repositories.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CountryController {
    @Autowired
    @Qualifier("countryRepository")
    private CountryRepository countryRepository;

    @GetMapping("/countries")
    public List<Country> countryList(){
        return countryRepository.findAll();
    }
}
