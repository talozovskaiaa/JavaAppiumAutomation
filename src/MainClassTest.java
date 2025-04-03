
import org.junit.Assert;
import org.junit.Test;

public class MainClassTest {
    @Test
    public void testGetLocalNumber() {
        MainClass mainClass = new MainClass();

        int actualResult = mainClass.getLocalNumber();
        int expectedResult = 15;

        Assert.assertTrue("Метод getLocalNumber должен возвращать число 14", actualResult == expectedResult);
    }
}
