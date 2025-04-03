
import org.junit.Assert;
import org.junit.Test;

public class MainClassTest {
    @Test
    public void testGetClassNumber() {
        MainClass mainClass = new MainClass();

        int actualResult = mainClass.getClassNumber();

        Assert.assertTrue("Метод getClassNumber должен возвращать число больше 45", actualResult > 45);
    }
}
