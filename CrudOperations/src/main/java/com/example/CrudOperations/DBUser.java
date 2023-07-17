package com.example.CrudOperations;

import java.util.ArrayList;
import java.util.List;

public class DBUser {
    private List<User> userTable=new ArrayList<User>();

    public DBUser(){
        userTable.add(new User( 1,"Naveen",22));
        userTable.add(new User( 2,"Elon Musk",52));
        userTable.add(new User( 3,"Mark Zuckerberg",39));
        userTable.add(new User( 4,"Bill Gates",67));
        userTable.add(new User( 5,"Steve Jobs",88));
    }

    public List<User> getAllUsers(){
        return userTable;
    }

    public User getAUserById(int id)
    {
        for(User user : userTable)
        {
            if (user.getId() == id) return user;
        }
        return null;
    }
    public User addUser(User user)
    {
        userTable.add(user);
        return user;
    }
    public boolean deleteAUserById(int id)
    {
        for(User user:userTable) {
            if (user.getId() == id)
                userTable.remove(user);
            return true;
        }
        return false;
    }

}
