package HW15.Test;

import HW15.NumToStr;
import org.junit.*;

import static org.junit.Assert.*;


public class HW15Test {

    @Test
    public void strToConsole() {
        assertTrue(NumToStr.strToConsole("12345"));
        assertTrue(NumToStr.strToConsole(67890));
        assertFalse(NumToStr.strToConsole("Sass"));
        assertFalse(NumToStr.strToConsole(""));
    }
}
