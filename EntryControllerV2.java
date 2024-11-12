package com.example.BasicApp.Controller;

import com.example.BasicApp.Entity.BasicEntry;
import com.example.BasicApp.service.BasicEntryService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/Basic")
public class EntryControllerV2 {

    @Autowired
    private BasicEntryService basicEntryService;

    @GetMapping
    public List<BasicEntry> getAll(){
        return basicEntryService.getAll();
    }

    @PostMapping
    public BasicEntry createEntry(@RequestBody BasicEntry myEntry){
        myEntry.setDate(LocalDateTime.now());
        basicEntryService.saveEntry(myEntry);
       return myEntry;
    }

    @GetMapping("id/{myId}")
    public BasicEntry getEntryById(@PathVariable ObjectId myId){
        return basicEntryService.findById(myId).orElse(null);
    }

    @DeleteMapping("id/{myId}")
    public boolean DeleteEntryById(@PathVariable ObjectId myId){
        basicEntryService.deleteById(myId);
        return true;
    }

    @PutMapping("/id/{id}")
    public BasicEntry updateEntryById(@PathVariable ObjectId id, @RequestBody BasicEntry myEntry){
        return null;
    }

}
