package com.ysyed;

import com.ysyed.command.Command;
import com.ysyed.command.commandparser.CommandParser;
import com.ysyed.command.commandparser.ParserSelector;
import com.ysyed.console.Console;
import com.ysyed.user.Users;

import java.util.Optional;

public class SocialNetwork {
    private Console console = new Console();
    private ParserSelector parserSelector = new ParserSelector();

    public void start() {
        String input;
        while((input = console.readCommand()) != null) {
            executeCommand(input);
        }
        console.write("Exiting...");
    }

    private void executeCommand(String input) {
        parserSelector.addParsers(new Users());
        Optional<CommandParser> parser = parserSelector.getParser(input);
        if(parser.isPresent()) {
            Command command = parser.get().parse(input);
            command.execute(console);
        } else {
            console.write("Unknown command issued");
        }
    }
}
