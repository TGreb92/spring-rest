package com.tgreb.skeleton.springrestmongo.controller;

import com.tgreb.skeleton.springrestmongo.model.People;
import com.tgreb.skeleton.springrestmongo.service.PeopleService;
import com.tgreb.skeleton.springrestmongo.util.ApiHelper;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/people")
public class PeopleController {

    private final PeopleService peopleService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<People> findAll(){
        return peopleService.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public People create(@RequestBody People people){
        ApiHelper.validate(people);
        return peopleService.save(people);
    }

    @PatchMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public People update(@PathVariable("id") String id, @RequestBody People people){
        ApiHelper.validate(people);
        return peopleService.update(id, people);
    }

    @GetMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.FOUND)
    public People findById(@PathVariable("id") String id){
        return peopleService.findById(id);
    }

    @DeleteMapping(value = "{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteById(@PathVariable("id") String id){
        peopleService.delete(id);
    }

}
