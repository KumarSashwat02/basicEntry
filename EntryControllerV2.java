package com.example.BasicApp.Controller;

import com.example.BasicApp.Entity.BasicEntry;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/Basic")
public class EntryControllerV2 {

    private HashMap<Long, BasicEntry> entries = new HashMap<>();


    @GetMapping
    public List<BasicEntry> getAllEntries(@RequestParam(required = false) String title) {
        if (title != null) {
            return entries.values().stream()
                    .filter(entry -> entry.getTitle().equalsIgnoreCase(title))
                    .collect(Collectors.toList());
        }
        return new ArrayList<>(entries.values());
    }


    @PostMapping
    public boolean createEntry(@RequestBody BasicEntry myEntry) {
        entries.put(myEntry.getId(), myEntry);
        return true;
    }

    /
    @GetMapping("/id/{myId}")
    public BasicEntry getEntryById(@PathVariable Long myId) {
        return entries.get(myId);
    }


    @DeleteMapping("/id/{myId}")
    public BasicEntry deleteEntryById(@PathVariable Long myId) {
        return entries.remove(myId);
    }


    @PutMapping("/id/{id}")
    public BasicEntry updateEntryById(
            @PathVariable Long id,
            @RequestParam(required = false) String title,
            @RequestParam(required = false) String content) {

        BasicEntry entry = entries.get(id);
        if (entry != null) {
            if (title != null) {
                entry.setTitle(title);
            }
            if (content != null) {
                entry.setContent(content);
            }
            entries.put(id, entry);
        }
        return entry;
    }


    @GetMapping("/search")
    public List<BasicEntry> searchEntries(
            @RequestParam(required = false) String title,
            @RequestParam(required = false) String content) {

        return entries.values().stream()
                .filter(entry -> (title == null || entry.getTitle().equalsIgnoreCase(title)) &&
                        (content == null || entry.getContent().contains(content)))
                .collect(Collectors.toList());
    }
}
