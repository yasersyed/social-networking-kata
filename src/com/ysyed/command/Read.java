package com.ysyed.command;

import com.ysyed.console.Console;
import com.ysyed.user.Message;
import com.ysyed.user.User;

public class Read implements Command{

    private final User user;

    public User getUser() {
        return this.user;
    }

    public Read(User user) {
        this.user = user;
    }

    @Override
    public void execute(Console console) {
        for(Message msg : user.getMessages()) {
            console.write(msg);
        }
    }
}
