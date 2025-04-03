import org.junit.Test;

public class MainClass {
    public int getLocalNumber() {
        return 14;
    }
}

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MainClassTest {
    @Test
    public void testGetLocalNumber() {
        MainClass mainClass = new MainClass();
        int result = mainClass.getLocalNumber();
        assertEquals("Метод должен возвращать 14", 14, result);
    }
}