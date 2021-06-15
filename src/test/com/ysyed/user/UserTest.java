package test.com.ysyed.user;

import com.ysyed.user.Message;
import com.ysyed.user.User;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.ZonedDateTime;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    private static final User user = new User("yaser");
    private static final User friend = new User("syed");
    private static Message message;

    @BeforeAll
    static void setup() {
        ZonedDateTime now = ZonedDateTime.now();
        String text = "Sending text!";
        message = new Message(user,now,text);
        user.addFriend(friend);
        user.postMessage(message);
    }

    @Test
    void getName() {
        assertTrue(user.getName().equals("yaser"));
    }

    @Test
    void getFriends() {
        assertTrue(user.getFriends().contains(friend));
    }

    @Test
    void getMessages() {
    }

    @Test
    void addFriend() {
        User friend2 = new User("Alice");
        user.addFriend(friend2);
        assertTrue(user.getFriends().contains(friend2));
    }

    @Test
    void addFriend2() {
        User friend3 = new User("Bob");
        assertFalse(user.getFriends().contains(friend3));
    }
}