package com.ysyed.command;

import com.ysyed.console.Console;
import com.ysyed.user.Message;
import com.ysyed.user.User;

import java.util.List;

public class Wall implements Command{

    private final User user;

    public Wall(User user) {
        this.user = user;
    }

    @Override
    public void execute(Console console) {
        List<Message> wall = user.getWall();
        for(Message msg : wall) {
            console.write(msg);
        }
    }

    public User getUser() {
        return user;
    }
}
