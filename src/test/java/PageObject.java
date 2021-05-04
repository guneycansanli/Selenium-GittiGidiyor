import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PageObject {

    //description we configurations, multiple pages separates in here main class----

        protected WebDriver driver;

        public PageObject(WebDriver driver){          //main object
            this.driver = driver;
            PageFactory.initElements(driver, this);
        }
}
