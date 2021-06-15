package com.ysyed.command.commandparser;

import com.ysyed.command.Command;
import com.ysyed.command.Post;
import com.ysyed.user.User;
import com.ysyed.user.Users;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PostParser implements CommandParser{

    private static final String PATTERN = "^(?<name>[^\\s]*) -> (?<message>.*)$";

    private Users users;

    public PostParser(Users users) {
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
        String message = matcher.group("message");

        User user = users.getOrCreate(name);

        Post command = new Post(user, message);
        return command;    }
}
