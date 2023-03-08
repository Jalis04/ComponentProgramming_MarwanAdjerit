package comp.prog.ex1;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        MessageFormatter formatter = new MessageFormatter();
        Greeter greeter = new Greeter(formatter);

        String greetings = greeter.greet(null);
        System.out.println(greetings);
    }
}