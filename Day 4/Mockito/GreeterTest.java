import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;

public class GreeterTest {

    @Test
    void testSayHello() {
        Translator mockTranslator = mock(Translator.class);

        when(mockTranslator.getGreeting()).thenReturn("hello");

        Greeter greeter = new Greeter(mockTranslator);

        String result = greeter.sayHello();

        assertEquals("HELLO", result);

        verify(mockTranslator).getGreeting();
    }
}