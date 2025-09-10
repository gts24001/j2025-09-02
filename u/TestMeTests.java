package u;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import c.TestMe;

public class TestMeTests {

    private TestMe testMe;

    @Before
    public void setUp() {
        // This method runs before each @Test
        testMe = new TestMe(5.0);
    }

    @Test
    public void testConstructorValue() {
        assertEquals(5.0, testMe.getValue(), 0.0001);
    }

    @Test
    public void testDefaultConstructorValue() {
        TestMe defaultTest = new TestMe();
        assertEquals(999.99, defaultTest.getValue(), 0.0001);
    }

    @Test
    public void testSquare() {
        assertEquals(25.0, testMe.square(), 0.0001);
    }

    @Test
    public void testSetValuePositive() {
        testMe.setValue(10.0);
        assertEquals(10.0, testMe.getValue(), 0.0001);
    }

    @Test
    public void testSetValueNegative() {
        testMe.setValue(-5.0);
        // Value should remain unchanged (5.0) since setter rejects negatives
        assertEquals(5.0, testMe.getValue(), 0.0001);
    }
}
//javac -cp junit-4.13.2.jar "./c/Hybrid.java" "./u/HybridTest.java" 
//java -cp "junit-4.13.2.jar:hamcrest-core-1.3.jar:./" org.junit.runner.JUnitCore u.TestMeTests
//java -cp "junit-4.13.2.jar:hamcrest-core-1.3.jar:./" org.junit.runner.JUnitCore u.HybridTest