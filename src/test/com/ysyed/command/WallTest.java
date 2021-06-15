package test.com.ysyed.command;

import com.ysyed.command.Wall;
import com.ysyed.console.Console;
import com.ysyed.user.Message;
import com.ysyed.user.User;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WallTest {

    private static Wall wall;
    private static User user;
    private static User friend;
    private static Console console;
    private static Message message1;
    private static Message message2;
    private static ZonedDateTime now;

    @BeforeAll
    public static void setup() {
        console = new Console();
        now = ZonedDateTime.now();
        user = new User("yaser");
        wall = new Wall(user);
        List<Message> msgs = new ArrayList<>();
        message1 = new Message(user, now,"Hello World!");
        message2 = new Message(user, now, "this is Yaser");
        msgs.add(message1);
        msgs.add(message2);
        friend = new User("syed");
        user.addFriend(friend);
    }
    @Test
    void execute() {
//        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
//        PrintStream ps = new PrintStream(outputStream);
//        System.setOut(ps);
        wall.execute(console);
//        System.out.println(outputStream.toString());
//        assertTrue(outputStream.equals("Hello World!"));
    }
}