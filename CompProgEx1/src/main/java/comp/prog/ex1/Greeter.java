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


}
