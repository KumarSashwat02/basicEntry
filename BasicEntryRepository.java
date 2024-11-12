package com.example.BasicApp.Repository;

import com.example.BasicApp.Entity.BasicEntry;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BasicEntryRepository extends MongoRepository<BasicEntry, ObjectId> {

}
