package test.com.ysyed.command;

import com.ysyed.command.Post;
import com.ysyed.console.Console;
import com.ysyed.user.Message;
import com.ysyed.user.User;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PostTest {

    private static Post post;
    private static User user;
    private static String text;
    private static Console console;

    @BeforeAll
    public static void setup(){
        user = new User("yaser");
        text = "hi";
        post = new Post(user,text);
        console = new Console();
    }

    @Test
    void execute() {
        post.execute(console);
        List<Message> messages = user.getMessages();
        messages.contains(text);
    }

    @Test
    void getUser() {
        assertEquals(post.getUser(),user);
    }

    @Test
    void getText() {
        assertEquals(post.getText(),text);
    }

}