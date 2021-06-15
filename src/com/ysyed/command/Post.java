package com.ysyed.command;

import com.ysyed.console.Console;
import com.ysyed.user.Message;
import com.ysyed.user.User;

import java.time.ZonedDateTime;

public class Post implements Command{

    private final User user;
    private final String text;

    public User getUser() {
        return user;
    }

    public String getText() {
        return text;
    }

    public Post(User user, String text) {
        this.user = user;
        this.text = text;
    }

    @Override
    public void execute(Console console) {
        Message message = new Message(user, ZonedDateTime.now(), text);
        user.postMessage(message);
    }
}
