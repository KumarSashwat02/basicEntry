package com.example.BasicApp.Controller;

import com.example.BasicApp.Entity.BasicEntry;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/Basic")
public class EntryController {

    private HashMap<Long, BasicEntry> entries = new HashMap<>();

    @GetMapping
    public List<BasicEntry> getAll(){
        return new ArrayList<>(entries.values());
    }

    @PostMapping
    public boolean createEntry(@RequestBody BasicEntry myEntry){
            entries.put(myEntry.getId(), myEntry);
            return true;
    }

    @GetMapping("id/{myId}")
    public BasicEntry getEntryById(@PathVariable Long myId){
        return entries.get(myId);
    }

    @DeleteMapping("id/{myId}")
    public BasicEntry DeleteEntryById(@PathVariable Long myId){
        return entries.remove(myId);
    }

    @PutMapping("/id/{id}")
    public BasicEntry updateEntryById(@PathVariable Long id, @RequestBody BasicEntry myEntry){
        return entries.put(id, myEntry);
    }

}
