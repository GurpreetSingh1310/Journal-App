package com.project.journalApp.controller;

import com.project.journalApp.entity.User;
import com.project.journalApp.service.UserEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class userEntryController {

    @Autowired
    private UserEntryService userEntryService;

    @GetMapping
    public List<User> getAllUsers() {
        return userEntryService.getAll();
    }

    @PostMapping
    public String createUser(@RequestBody User user) {
        userEntryService.saveEntry(user);
        return "User created";
    }

    @PutMapping("/{userName}")
    public ResponseEntity<String> updatedUser(@RequestBody User user, @PathVariable String userName) {
        User userInDb = userEntryService.findByUsername(userName);
        if (userInDb != null) {
            userInDb.setUsername(user.getUsername());
            userInDb.setPassword(user.getPassword());
            userEntryService.saveEntry(userInDb);
            return new ResponseEntity<>("User updated", HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
