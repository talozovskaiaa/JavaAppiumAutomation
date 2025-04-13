
import org.junit.Assert;
import org.junit.Test;

public class MainClassTest {
    @Test
    public void testGetClassString() {
        MainClass mainClass = new MainClass();

        Object actualResult = mainClass.getClassString();

        Assert.assertTrue("Возвращаемое значение должно быть строкой", actualResult instanceof String);

        String strResult = (String) actualResult;

        boolean containsHello = strResult.contains("Hello") || strResult.contains("hello");

        Assert.assertTrue("Строка должна содержать Hello или hello", containsHello);

    }
}
