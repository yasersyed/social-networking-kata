package test.com.ysyed.console;

import com.ysyed.console.MessageParser;
import com.ysyed.user.Message;
import com.ysyed.user.User;
import org.junit.jupiter.api.Test;

import java.time.ZonedDateTime;

import static org.junit.jupiter.api.Assertions.*;

class MessageParserTest {

    private static final User user = new User("yaser");
    private static final String text = "Hi there!";
    private MessageParser messageParser = new MessageParser();

    @Test
    void parse() {
        ZonedDateTime now = ZonedDateTime.now();
        Message msg = new Message(user,now,text);
        String line = messageParser.parse(msg);
        assertTrue(line.matches("yaser-Hi there! \\(0 seconds ago\\)"));
    }
}