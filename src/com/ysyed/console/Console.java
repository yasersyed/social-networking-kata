package com.ysyed.console;

import com.ysyed.user.Message;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Console {
    private BufferedReader reader;
    private MessageParser parser = new MessageParser();
    public Console() {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public String readCommand() {
        try {
            return reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException("Read Command Failed", e);
        }
    }
    public void write(Message message) {
        String line = parser.parse(message);
        write(line);
    }

    public void write(String text) {
        System.out.println(text);
    }
}
