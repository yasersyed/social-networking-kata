package com.ysyed.command.commandparser;

import com.ysyed.command.Command;
import com.ysyed.user.Users;

public interface CommandParser {
    public Users users = new Users();
    public boolean canHandle(String line);
    public Command parse(String line);
}
