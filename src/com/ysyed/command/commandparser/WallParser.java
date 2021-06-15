package com.ysyed.command.commandparser;

import com.ysyed.command.Command;
import com.ysyed.command.Wall;
import com.ysyed.user.User;
import com.ysyed.user.Users;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WallParser implements CommandParser{

    private static final String PATTERN = "^(?<name>[^\\s]*) wall$";
    private Users users;

    public WallParser(Users users) {
        this.users = users;
    }

    @Override
    public boolean canHandle(String line) {
        return line.matches(PATTERN);
    }

    @Override
    public Command parse(String line) {

        Matcher matcher = Pattern.compile(PATTERN).matcher(line);

        if (!matcher.matches()) {
            throw new IllegalArgumentException("Un parsable line " + line);
        }

        String name = matcher.group("name");

        User user = users.getOrCreate(name);
        Wall wallCmd = new Wall(user);
        return wallCmd;
    }
}
