package test.com.ysyed.command;

import com.ysyed.command.Follow;
import com.ysyed.console.Console;
import com.ysyed.user.User;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FollowTest {
    private static Follow follow;
    private static User user;
    private static User friend;
    private static Console console;

    @BeforeAll
    public static void setup(){
        user = new User("yaser");
        friend = new User("syed");
        follow = new Follow(user,friend);
        console = new Console();
    }

    @Test
    public void test1() {
        follow.execute(console);
        assertTrue(user.getFriends().contains(friend));
    }
}