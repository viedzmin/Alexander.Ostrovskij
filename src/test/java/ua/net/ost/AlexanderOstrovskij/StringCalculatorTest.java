package ua.net.ost.AlexanderOstrovskij;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

@RunWith(JUnitParamsRunner.class)
public class StringCalculatorTest {

    private static StringCalculator testClass;

    @BeforeClass
    public static void setup() {
        testClass = new StringCalculator();
    }

    @Test
    public void calculate_TestNullInput() {
        String value = testClass.calculate(null);
        assertEquals("",value );
    }

    public void calculate_TestEmptyInput() {
        String value = testClass.calculate("");
        assertEquals("",value );
    }

    @Test
    @Parameters({"1, 1\\,1\n", "01AF04F, 0\\,2\n1\\,1\n4\\,1\nA\\,1\nF\\,2\n"})
    public void calculate_TestStrings(String input, String expected) {
        String calculatedString = testClass.calculate(input);
        assertEquals(expected,calculatedString);
    }


}
