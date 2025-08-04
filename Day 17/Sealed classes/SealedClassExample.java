public class SealedClassExample {

    // 🔹 Sealed class
    public sealed class Shape permits Circle, Rectangle, Triangle {
        public void display() {
            System.out.println("This is a shape.");
        }
    }

    // 🔹 Final subclass
    public final class Circle extends Shape  {
        public void draw() {
            System.out.println("Drawing Circle");
        }
    }

    // 🔹 Sealed subclass
    public sealed class Rectangle extends Shape permits SmallRectangle  {
        public void draw() {
            System.out.println("Drawing Rectangle");
        }
    }

    public final class SmallRectangle extends Rectangle {
        public void draw() {
            System.out.println("Drawing Small Rectangle");
        }
    }

    // 🔹 Non-sealed subclass
    public non-sealed class Triangle extends Shape {
        public void draw() {
            System.out.println("Drawing Triangle");
        }
    }

    public class RightAngleTriangle extends Triangle {
        public void draw() {
            System.out.println("Drawing Right Angle Triangle");
        }
    }

    // 🔹 Main method
    public static void main(String[] args) {
        SealedClassExample example = new SealedClassExample();

        Shape s1 = example.new Circle();
        Shape s2 = example.new SmallRectangle();
        Shape s3 = example.new RightAngleTriangle();

        s1.display();
        ((Circle)s1).draw();

        s2.display();
        ((SmallRectangle)s2).draw();

        s3.display();
        ((RightAngleTriangle)s3).draw();
    }
}


//sealed classses

// When you write a sealed class, you control which classes can extend it using permits.

// Then, the permitted classes must be either:

// final → no one else can extend them ✅

// sealed → restrict further extension ✅

// non-sealed → allow others to extend freely ✅