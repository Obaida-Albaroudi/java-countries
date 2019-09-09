package com.lambdaschool.javacountries;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/population")
public class CountryPopulationController {

    @GetMapping(value = "size/{people}",
            produces = {"application/json"})
    public ResponseEntity<?> getCountriesByPopulationSize(@PathVariable int people)
    {
        ArrayList<Country> pop = JavacountriesApplication.ourCountryList
                .findCountries(e -> e.getPopulation() >= people);
        pop.sort((e1, e2) -> ((e2.getPopulation() - e1.getPopulation())));
        return new ResponseEntity<>(pop, HttpStatus.OK);
    }

    @GetMapping(value = "/min",
            produces = {"application/json"})
    public ResponseEntity<?> getMin()
    {
        ArrayList<Country> min = JavacountriesApplication.ourCountryList.findCountries(e -> e.getPopulation() >= 0);
        min.sort((e1, e2) -> ((e1.getPopulation() - e2.getPopulation())));

        return new ResponseEntity<>( min.stream().findFirst(), HttpStatus.OK);
    }

    @GetMapping(value = "/max",
            produces = {"application/json"})
    public ResponseEntity<?> getMax()
    {
        ArrayList<Country> max = JavacountriesApplication.ourCountryList.findCountries(e -> e.getPopulation() >= 0);
        max.sort((e1, e2) -> ((e2.getPopulation() - e1.getPopulation())));

        return new ResponseEntity<>( max.stream().findFirst(), HttpStatus.OK);
    }
}
