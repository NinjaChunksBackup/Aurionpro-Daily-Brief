public class SealedInterfaceExample {

    // 🔹 Sealed interface
    public sealed interface Vehicle permits Car, Bus, Bike { 
        void start();
    }

    // 🔹 Final class - cannot be extended
    public final class Car implements Vehicle {
        public void start() {
            System.out.println("Car is starting");
        }
    }

    // 🔹 Sealed class - only permitted subclasses can extend
    public sealed class Bus implements Vehicle permits MiniBus {
        public void start() {
            System.out.println("Bus is starting");
        }
    }

    public final class MiniBus extends Bus {
        public void start() {
            System.out.println("MiniBus is starting");
        }
    }

    // 🔹 Non-sealed class - anyone can extend it
    public non-sealed class Bike implements Vehicle {
        public void start() {
            System.out.println("Bike is starting");
        }
    }

    public class SportsBike extends Bike {
        public void start() {
            System.out.println("Sports Bike is starting");
        }
    }

    // 🔹 Main method
    public static void main(String[] args) {
        SealedInterfaceExample example = new SealedInterfaceExample();

        Vehicle v1 = example.new Car();
        Vehicle v2 = example.new MiniBus();
        Vehicle v3 = example.new SportsBike();

        v1.start(); // Car is starting
        v2.start(); // MiniBus is starting
        v3.start(); // Sports Bike is starting
    }
}
