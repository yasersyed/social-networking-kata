package com.ysyed.command.commandparser;

import com.ysyed.command.Follow;
import com.ysyed.user.Users;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ParserSelector {
    private List<CommandParser> parserList = new ArrayList<>();

    public void addParsers(Users users) {
        this.parserList.add(new FollowParser(users));
        this.parserList.add(new PostParser(users));
        this.parserList.add(new ReadParser(users));
        this.parserList.add(new WallParser(users));
    }

    public Optional<CommandParser> getParser(String line) {
        return parserList.stream().filter(p->p.canHandle(line)).findFirst();
    }
}
