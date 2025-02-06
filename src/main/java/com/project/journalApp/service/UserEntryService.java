package com.project.journalApp.service;

import com.project.journalApp.entity.User;
import com.project.journalApp.repository.UserRepo;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class UserEntryService {

    @Autowired
    private UserRepo userRepo;

    public void saveEntry(User user) {
        userRepo.save(user);
    }

    public List<User> getAll() {
        return userRepo.findAll();
    }

    public Optional<User> getById(ObjectId id) {
        return userRepo.findById(id);
    }

    public void deleteById(ObjectId id) {
        userRepo.deleteById(id);
    }

    public User findByUsername(String username) {
        return userRepo.findByUsername(username);
    }
}
