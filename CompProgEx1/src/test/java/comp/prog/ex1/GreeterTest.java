package comp.prog.ex1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GreeterTest {

    @Test
    void testNullGreet() {
        MessageFormatter formatter = new MessageFormatter();
        Greeter greeter = new Greeter(formatter);

        // Test with null value
        String result = greeter.greet(null);
        assertNull(result);
        //assertEquals("Hello  !", result); Not sure if this test isnt redundant with the next one
    }

    @Test
    void testEmptyGreet() {
        MessageFormatter formatter = new MessageFormatter();
        Greeter greeter = new Greeter(formatter);

        // Test with empty string
        String result = greeter.greet("");
        assertEquals("Hello  !", result);
    }

    @Test
    void testStudentGreet() {
        MessageFormatter formatter = new MessageFormatter();
        Greeter greeter = new Greeter(formatter);

        // Test with String  value
        String result = greeter.greet("Student");
        //assertSame("Hello Student !", result); tried an assertSame
        assertEquals("Hello Student !", result);
    }
}
