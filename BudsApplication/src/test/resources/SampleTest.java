import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

public class SampleTest {
  @Test
  public void f() {
	  System.out.println("This is a test method.");
  }
  @BeforeTest
  public void beforeTest() {
  }

}
