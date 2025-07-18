import java.util.Optional;

public class OptionalExample {
    public static void main(String[] args) {
        Optional<String> name1 = Optional.of("Manish");
        Optional<String> name2 = Optional.empty();
        
        if (name1.isPresent()) {
            System.out.println(name1.get());
        }
        
        if (name2.isPresent()) {
            System.out.println(name2.get());
        } else {
            System.out.println("No name");
        }
    }
}