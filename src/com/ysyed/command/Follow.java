package com.ysyed.command;

import com.ysyed.console.Console;
import com.ysyed.user.User;

public class Follow implements Command{

    private final User user;
    private final User friend;

    public Follow(User user, User friend){
        this.user = user;
        this.friend = friend;
    }

    @Override
    public void execute(Console console) {
        user.addFriend(friend);
    }
}
