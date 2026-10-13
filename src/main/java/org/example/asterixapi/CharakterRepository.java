package org.example.asterixapi;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface CharakterRepository extends MongoRepository <Character, String> {

}
