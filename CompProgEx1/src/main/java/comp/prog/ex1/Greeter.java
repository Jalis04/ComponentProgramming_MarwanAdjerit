package comp.prog.ex1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Greeter {
    private MessageFormatter formatter;

    public Greeter(MessageFormatter formatter){
        this.formatter = formatter;
    }

    public String greet(String who){
        return formatter.format(who);
    }


    public class GreeterTest {
        @Test
        public void testGreet() {
            MessageFormatter formatter = new MessageFormatter();
            Greeter greeter = new Greeter(formatter);

            // Test with null value
            String result1 = greeter.greet(null);
            assertNull(result1);

            // Test with empty string
            String result2 = greeter.greet("");
            assertEquals("Hello, !", result2);

            // Test with "Student" string
            String result3 = greeter.greet("Student");
            assertSame("Hello, Student!", result3);
        }
    }
}
