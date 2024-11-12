package com.example.BasicApp.service;

import com.example.BasicApp.Entity.BasicEntry;
import com.example.BasicApp.Repository.BasicEntryRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class BasicEntryService {
    @Autowired
    private BasicEntryRepository basicEntryRepository;

    public void saveEntry(BasicEntry basicEntry){
        basicEntryRepository.save(basicEntry);
    }

    public List<BasicEntry> getAll(){
        return basicEntryRepository.findAll();
    }

    public Optional<BasicEntry> findById(ObjectId id){
        return basicEntryRepository.findById(id);
    }

    public void deleteById(ObjectId id){
        basicEntryRepository.deleteById(id);
    }


}



// The Flow
// controller -----> Service ------> repository