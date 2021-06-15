package com.ysyed.user;

import com.ysyed.console.Console;

import java.util.*;

public class User {
    private String name;
    private Set<User> friends;
    private List<Message> messages;

    public User(String name) {
        this.name = name;
        this.friends = new HashSet<>();
        this.messages = new LinkedList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<User> getFriends() {
        return Collections.unmodifiableSet(friends);
    }

    public void setFriends(Set<User> friends) {
        this.friends = friends;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public void addFriend(User friend) {
        friends.add(friend);
    }

    public void postMessage(Message message) {
        messages.add(message);
    }

    public List<Message> getWall() {
        List<Message> wall = new ArrayList<>();
        wall.addAll(getMessages());
        for (User friend : friends) {
            wall.addAll(friend.getMessages());
        }

        wall.sort((m1, m2) -> m2.getSentTime().compareTo(m1.getSentTime()));

        return wall;
    }
}
