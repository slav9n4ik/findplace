package ru.findplace.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.test.context.junit4.SpringRunner;
import ru.findplace.demo.entity.User;

import java.io.IOException;

import static org.assertj.core.api.Assertions.*;

@RunWith(SpringRunner.class)
@JsonTest
public class NewTest {

    JacksonTester<User> json;

    @Test
    public void testFoo() throws IOException {
        //User user = new User("adad","123","USER");
        //this.json.write(user);
        //assertThat(this.json.write(user)).isEqualTo("user.json");
        //System.out.println("HELLO");
    }
}
