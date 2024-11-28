import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
//
import org.junit.platform.engine.TestEngine;
//
import java.util.Iterator;
import java.util.ServiceLoader;
//
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculatorTest {

    @Test
    @DisplayName("Add two numbers")
    void add() {
        assertEquals(4, Calculator.add(2, 2));
    }

    @Test
    @DisplayName("Multiply two numbers")
    void multiply() {
        assertAll(() -> assertEquals(4, Calculator.multiply(2, 2)),
                () -> assertEquals(-4, Calculator.multiply(2, -2)),
                () -> assertEquals(4, Calculator.multiply(-2, -2)),
                () -> assertEquals(0, Calculator.multiply(1, 0)));
    }

    @BeforeAll
    static void beforeAll() {
        // Display the version of JUnit 5 being used at runtime.
        final ServiceLoader<TestEngine> loader = ServiceLoader.load(TestEngine.class);
        final Iterator<TestEngine> iterator = loader.iterator();
        final TestEngine testEngine = iterator.next();
        String version = "unknown";
        if(testEngine.getVersion().isPresent()){
            version = testEngine.getVersion().get();
        }
        System.out.println("JUnit Test Engine Version: " + version);
    }
}