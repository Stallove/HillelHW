package HW17.Test;

import static org.junit.Assert.*;

import HW17.XmlValidation;
import org.junit.Test;

public class XmlTest {
    @Test
    public void isValid() {
        assertFalse(XmlValidation.isValid("D:\\Hillel\\HillelHW\\src\\main\\java\\HW17\\hw17Resources\\WrongXml.xml"));
        System.out.println(false);
        assertTrue(XmlValidation.isValid("D:\\Hillel\\HillelHW\\src\\main\\java\\HW17\\hw17Resources\\RightXml.xml"));
        System.out.println(true);
    }
}
