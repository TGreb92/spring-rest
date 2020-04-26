package com.tgreb.skeleton.springrestmongo.service;

import com.tgreb.skeleton.springrestmongo.model.People;
import com.tgreb.skeleton.springrestmongo.repository.PeopleRepository;
import com.tgreb.skeleton.springrestmongo.util.ServiceHelper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;


@Service
@AllArgsConstructor
@Slf4j
public class PeopleService {
    private final PeopleRepository peopleRepository;

    public List<People> findAll(){
        return peopleRepository.findAll();
    }

    public People findById(String id){
        var owner = peopleRepository.findById(id);
        return owner.orElseThrow( () -> new NoSuchElementException("Owner not found with id: ".concat(id)));
    }

    public People save(People people){
        log.info("Saving new people: {}", people);
        return peopleRepository.insert(people);
    }

    public People update(String id, People people){
        var foundEntity = findById(id);
        var updatedEntity = ServiceHelper.merge(people, foundEntity);
        log.info("Updating people: {}", foundEntity);
        return peopleRepository.save(updatedEntity);
    }

    public void delete(String id){
        peopleRepository.deleteById(id);
    }
}
