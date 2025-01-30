package com.project.journalApp.controller;

import com.project.journalApp.entity.JournalEntry;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/journal")
public class JournalEntryController {

    private Map<Long, JournalEntry> journalEntries = new HashMap<>();

    @GetMapping
    public List<JournalEntry> getAll() {
        return new ArrayList<>(journalEntries.values());
    }

    @PostMapping
    public String createJournalEntry(@RequestBody JournalEntry myEntry) {
        journalEntries.put(myEntry.getId(), myEntry);
        return "Entry Added";
    }

    @GetMapping("/id/{myId}")
    public JournalEntry getJournalEntryById(@PathVariable long myId) {
        return journalEntries.get(myId);
    }

    @DeleteMapping("id/{myId}")
    public boolean deleteJournalEntryById(@PathVariable long myId) {
        return journalEntries.remove(myId) != null;
    }

    @PutMapping("/id/{id}")
    public JournalEntry updateJournalEntryById(@PathVariable long id, @RequestBody JournalEntry myEntry) {
        return journalEntries.put(id, myEntry);

    }
}
