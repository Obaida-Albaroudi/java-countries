package com.lambdaschool.javacountries;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/names")

public class CountryNameController
{
    // localhost:2019/names/all
    @GetMapping(value = "/all",
            produces = {"application/json"})
    public ResponseEntity<?> getAllCountries()
    {
        return new ResponseEntity<>(JavacountriesApplication.ourCountryList.countryList, HttpStatus.OK);
    }

    // localhost:2019/names/start/{letter}
    @GetMapping(value = "start/{letter}",
            produces = {"application/json"})
    public ResponseEntity<?> getCountriesByFirstLetter(@PathVariable char letter)
    {
        ArrayList<Country> letters = JavacountriesApplication.ourCountryList
                .findCountries(e -> e.getName().toUpperCase().charAt(0) == Character.toUpperCase(letter));
        letters.sort((v1,v2) -> v1.getName().compareToIgnoreCase(v2.getName()));
        return new ResponseEntity<>(letters, HttpStatus.OK);
    }

    // localhost:2019/names/start/{number}
    @GetMapping(value = "size/{number}",
            produces = {"application/json"})
    public ResponseEntity<?> getByWordLength(@PathVariable int number)
    {
        ArrayList<Country> wordLength = JavacountriesApplication.ourCountryList
                .findCountries(e -> e.getWordLength() >= number);
        wordLength.sort((v1,v2) -> v1.getName().compareToIgnoreCase(v2.getName()));
        return new ResponseEntity<>(wordLength, HttpStatus.OK);
    }
}
