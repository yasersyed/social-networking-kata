package com.ysyed.user;

import java.time.ZonedDateTime;

public class Message {
    private final User from;
    private final ZonedDateTime sentTime;
    private final String text;

    public Message(User from, ZonedDateTime sentTime, String text) {
        this.from = from;
        this.sentTime = sentTime;
        this.text = text;
    }

    public User getFrom() {
        return from;
    }

    public ZonedDateTime getSentTime() {
        return sentTime;
    }

    public String getText() {
        return text;
    }
}
