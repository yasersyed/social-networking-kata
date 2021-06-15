package com.ysyed.user;

import java.util.HashMap;
import java.util.Map;

public class Users {

    private Map<String, User> userMap;

    public Users() {
        userMap = new HashMap<>();
    }

    public Map<String, User> getUserMap() {
        return userMap;
    }

    public void addUser(User user) {
        userMap.put(user.getName(),user);
    }

    public User getOrCreate(String username) {
        if(existsInMap(username)) {
            return userMap.get(username);
        }
        User user = new User(username);
        addUser(user);
        return user;
    }

    private boolean existsInMap(String username) {
        if(userMap.containsKey(username)) {
            return true;
        }
        return false;
    }

}
