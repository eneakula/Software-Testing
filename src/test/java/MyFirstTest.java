import org.example1.Calculator;
import org.junit.jupiter.api.*;

public class MyFirstTest {

    @Test
    void shouldAddTwo(){
        System.out.println("Inside test add");
        int a = 2;
        int b = 3;
        int actualResult = Calculator.add(2,3);
        int expectedResult = 5;

        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    @Disabled
    @DisplayName("Add method")
    void shouldSubtractTwo(){
        System.out.println("Inside test add");

        int a=3;
        int b=2;
        int actualResult = Calculator.subtract(a,b);
        int expectedResult = 1;

        Assertions.assertEquals(expectedResult, actualResult);
    }

@Test
    void shouldMultiplyTwo(){
    System.out.println("Inside test add");
    int actualResult = Calculator.multiply(3,3);
    int expectedResult = 9;
    Assertions.assertEquals(expectedResult, actualResult);

}

@BeforeEach
    void starttest(){
        System.out.println("This method will be executed" + "before every test");

}

@AfterEach
void endtest(){
    System.out.println("This method will be executed" + "before every test");
}

@BeforeAll
    static void initTests(){
        System.out.println("Before all tests");

}

@AfterAll
   static void endTests(){
    System.out.println("After all tests");
}

}

