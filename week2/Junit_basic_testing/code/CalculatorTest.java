import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;

public class CalculatorTest {

    private Calculator calc;

    @Before
    public void setUp() {
        calc = new Calculator();
        System.out.println("Setup executed before each test.");
    }

    @After
    public void tearDown() {
        System.out.println("Teardown executed after each test.");
    }

    @Test
    public void testAdd_AAA() {
        // Arrange done in @Before
        // Act
        int result = calc.add(2, 3);
        // Assert
        assertEquals(5, result);
    }

    @Test
    public void testSubtract_AAA() {
        int result = calc.subtract(10, 4);
        assertEquals(6, result);
    }
}
