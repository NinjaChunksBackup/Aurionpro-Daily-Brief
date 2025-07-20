public class Greeter {
    private Translator translator;

    public Greeter(Translator translator) {
        this.translator = translator;
    }

    public String sayHello() {
        String greeting = translator.getGreeting();
        return greeting.toUpperCase();
    }
}