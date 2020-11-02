package study;

// import org.junit.jupiter.api.Test;
// import static org.junit.jupiter.api.Assertions.assertEquals;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
// import org.testng.annotations.AfterTest;
// import org.testng.annotations.BeforeTest;
// import org.testng.asserts.SoftAssert;
import org.w3c.dom.ranges.RangeException;

/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     *
     */
    @DataProvider(name = "forAbs")
    Object[][] dataAbs() {
        return new Object[][] {{0}, {1},
            {123}, {-123},
            {Integer.MIN_VALUE}, {Integer.MAX_VALUE} };
    }
    /**
     *
     */
    @Test(dataProvider = "forAbs")
    public void testAbs(int number) {
        System.out.println("Тест 1. Проверка функции Math.abs(a)");
        try {
            Assert.assertFalse(number ==  Integer.MIN_VALUE, number + " лежит за пределами допустимого диапазона!");

            int abs = Math.abs(number);
            Assert.assertEquals(abs, number * (number < 0 ? -1 : 1), "Значение вычисленно неправильно!");
            System.out.println("|" + number + "| = " + abs);
        } catch (AssertionError ae) {
            System.out.println(ae.getMessage());
        }
        System.out.println();
    }

    /**
     *
     */
    @DataProvider(name = "forAddExact")
    Object[][] dataAddExact() {
        return new Object[][] {{0, 0}, {1, 1}, {0, 1}, {-1, 1}, {-1, 0},
        {Integer.MIN_VALUE, -1}, {Integer.MAX_VALUE, 1},
        {Integer.MIN_VALUE, 1}, {Integer.MAX_VALUE, -1},
        {Integer.MIN_VALUE, Integer.MAX_VALUE}};
    }
    /**
     *
     */
    @Test(dataProvider = "forAddExact")
    public void testAddExact(int number1, int number2) {
        System.out.println("Тест 2. Проверка функции Math.addExact(a, b)");
        try {
            int sum = Math.addExact(number1, number2);
            System.out.println(number1 + " + " + number2 + " = " + sum);
            Assert.assertEquals(sum, number1 + number2, "Значение вычисленно неправильно!");
        } catch (ArithmeticException ex) {
            System.out.println("Значение вышло за пределы диапазона!");
        } catch (AssertionError ae) {
            System.out.println(ae.getMessage());
        }
        System.out.println();
    }

    /**
     *
     */
    @DataProvider(name = "forFloorDiv")
    Object[][] dataFloorDiv() {
        return new Object[][] {{0, 0}, {1, 1}, {0, 1}, {-1, 1}, {1, -1}, {-1, 0}, {-1, -1},
        {Integer.MIN_VALUE, -1}, {Integer.MAX_VALUE, 1},
        {Integer.MIN_VALUE, 1}, {Integer.MAX_VALUE, -1},
        {Integer.MIN_VALUE, -2}, {Integer.MAX_VALUE, 2},
        {Integer.MIN_VALUE, 2}, {Integer.MAX_VALUE, -2},
        {Integer.MIN_VALUE, Integer.MAX_VALUE},
        {Integer.MAX_VALUE, Integer.MIN_VALUE}};
    }
    /**
     *
     */
    @Test(dataProvider = "forFloorDiv")
    public void testFloorDiv(int number1, int number2) {
        System.out.println("Тест 3. Проверка функции Math.floorDiv(a, b)");
        try {
            int div = Math.floorDiv(number1, number2);
            System.out.println(number1 + " / " + number2 + " = " + div);
            Assert.assertFalse(number1 == Integer.MIN_VALUE && number2 == -1, "Значение превышает диапазон!");
        } catch (ArithmeticException ex) {
            System.out.println("Нельзя делить на 0!");
        } catch (AssertionError ae) {
            System.out.println(ae.getMessage());
        }
        System.out.println();
    }
}
