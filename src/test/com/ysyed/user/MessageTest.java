package test.com.ysyed.user;

import com.ysyed.user.Message;
import com.ysyed.user.User;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.ZonedDateTime;

import static org.junit.jupiter.api.Assertions.*;

class MessageTest {

    private static User user = new User("yaser");
    private static String text = "Hi There!";
    private static ZonedDateTime now = ZonedDateTime.now();
    private static Message message;
    @BeforeAll
    static void setup() {
        message = new Message(user,now,text);
    }
    @Test
    void getFrom() {
        assertTrue(message.getFrom().equals(user));
    }

    @Test
    void getSentTime() {
        assertTrue(message.getSentTime().equals(now));
    }

    @Test
    void getText() {
        assertTrue(message.getText().equals(text));
    }
}