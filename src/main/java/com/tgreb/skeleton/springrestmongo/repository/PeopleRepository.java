package com.tgreb.skeleton.springrestmongo.repository;

import com.tgreb.skeleton.springrestmongo.model.People;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeopleRepository extends MongoRepository<People, String> {
}
