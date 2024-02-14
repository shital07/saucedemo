import org.testng.annotations.Test;
import utility.BaseClass;

public class Demo extends BaseClass {


    @Test
    public void firstTest(){
        driver.get("https://www.google.com");

    }

}
