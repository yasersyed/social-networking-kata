package com.ysyed.console;

import com.ysyed.user.Message;
import com.ysyed.user.User;

import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;

public class MessageParser {
    public String parse(Message message) {
        StringBuilder str = new StringBuilder();

        User from = message.getFrom();
        str.append(from.getName());
        str.append("-");
        str.append(message.getText());

        ZonedDateTime msgSentTime = message.getSentTime();
        long seconds = msgSentTime.until(ZonedDateTime.now(), ChronoUnit.SECONDS);

        if (seconds < 60) {
            str.append(" (").append(seconds).append(" seconds ago)");
        } else {
            long minutes = msgSentTime.until(ZonedDateTime.now(), ChronoUnit.MINUTES);
            str.append(" (").append(minutes).append(" minutes ago)");
        }

        return str.toString();
    }
}
