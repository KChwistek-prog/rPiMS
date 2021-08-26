package com.raspberrypi.fermzilla.rpims.mongodb;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BatchRepo extends MongoRepository<BatchPojo, String> {

}
