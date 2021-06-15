package test.com.ysyed.command;

import com.ysyed.command.Read;
import com.ysyed.console.Console;
import com.ysyed.user.Message;
import com.ysyed.user.User;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.ZonedDateTime;

import static org.junit.jupiter.api.Assertions.*;

class ReadTest {

    private static Read read;
    private static User user;
    private static Message message;
    private static Console console;

    @BeforeAll
    public static void setup(){
        user = new User("yaser");
        read = new Read(user);
        console = new Console();
        message = new Message(user, ZonedDateTime.now(),"Hi!");
        user.postMessage(message);
    }

    @Test
    void execute() {
        read.execute(console);
        assertTrue(user.getMessages().contains(message));
    }

    @Test
    void getUser() {
        assertTrue(read.getUser().equals(user));
    }


}