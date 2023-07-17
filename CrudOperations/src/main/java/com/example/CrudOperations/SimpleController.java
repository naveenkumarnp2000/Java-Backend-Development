package com.example.CrudOperations;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SimpleController {
    DBUser db=new DBUser();
    @GetMapping("/hi")
    public String sayHi(){
        return "Hello from our server";
    }
    @GetMapping("/users")
    public List<User> getAllUser()
    {
        return db.getAllUsers();
    }
    @GetMapping("/users/{id}")
    public User getAUser(@PathVariable int id){
        return db.getAUserById(id);
    }
    @PostMapping("/users")
    public User createAUser(@RequestBody User user )
    {
        return db.addUser(user);
    }
    @DeleteMapping("/users/{id}")
    public boolean deleteAUser(@PathVariable int id)
    {
        return db.deleteAUserById(id);
    }
}
