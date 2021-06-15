package com.ysyed.command.commandparser;

import com.ysyed.command.Command;
import com.ysyed.command.Follow;
import com.ysyed.user.User;
import com.ysyed.user.Users;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FollowParser implements CommandParser{

    public static final String PATTERN = "^(?<name>[^\\s]*) follows (?<friend>[^\\s]*)$";

    private Users users;

    public FollowParser(Users users) {
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

        String userName = matcher.group("name");
        String friendName = matcher.group("friend");

        User user = users.getOrCreate(userName);
        User friend = users.getOrCreate(friendName);

        Follow followCmd = new Follow(user,friend);
        return followCmd;
    }
}
