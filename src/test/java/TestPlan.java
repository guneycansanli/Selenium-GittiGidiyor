import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class TestPlan {

    private static final WebDriver driver = new ChromeDriver();

    //guneycansanli@hotmail.com
    //123abc

    @BeforeSuite
    public static void main(String[] args) {
        // ChromeDriver location set up in Utils class
        System.setProperty("webdriver.chrome.driver.exe", Utils.CHROME_DRIVER_LOCATION);
    }

    @Test(testName = "Gittigidiyor")
    public static void start() throws InterruptedException {

        openThePage();
        loginToPage();
        searchInMain();
        selectToSecondPage();
        selectItem();
        addToBasket();
        addOneItem();
        deleteBasket();

        /*
        WebForm webForm = new WebForm(driver);
        webForm.enterFirstName();
        webForm.enterLastName();
        webForm.pressSubmitButton();
         */
    }

    public static void openThePage() throws InterruptedException {

        String mainPage = "https://gittigidiyor.com/";
        driver.get(Utils.BASE_URL);
        driver.manage().window().maximize();
        if (mainPage == Utils.BASE_URL) {
            System.out.println("You reached the correct URL");
        } else {
            System.out.println("You reached the wrong URL!!!!");
        }
        Thread.sleep(1000);

    }

    public static void loginToPage() throws InterruptedException {

        String myEmail = "guneycansanli@hotmail.com";
        String myPassword = "123abc";

        if (myEmail == Utils.USER_EMAIL && myPassword==Utils.PASSWORD){
            WebForm webForm = new WebForm(driver);
            webForm.pressLoginDiv();
            Thread.sleep(1000);

            webForm.pressLoginButton();
            webForm.enterEmail();
            webForm.enterPassword();
            webForm.signIn();

            System.out.println("You have correct information(email and password).");
        }else{
            System.out.println("You have wrong information.!!!!");
        }
        Thread.sleep(1000);

    }

    public static void searchInMain() throws InterruptedException {

        WebForm webForm = new WebForm(driver);
        webForm.searchInput("bilgisayar");
        Thread.sleep(1000);
        webForm.pressSearchButton();

    }

    public static void selectToSecondPage() throws InterruptedException {

        WebForm webForm = new WebForm(driver);
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0,9000)");
        Thread.sleep(1000);
        driver.findElement(By.cssSelector(".pager.pt30>:first-child>:nth-child(2)>:first-child")).click();

        if(webForm.getUrl() == Utils.SECOND_PAGE_URL){
            System.out.println("You are in second page");
        }else {
            System.out.println("You are not in second page");
        }
        Thread.sleep(1000);

    }

    public static void selectItem() throws InterruptedException {

        WebForm webForm = new WebForm(driver);
        webForm.selectItem();
        Thread.sleep(2000);

    }

    public static void addToBasket() throws InterruptedException {

        WebForm webForm = new WebForm(driver);
        String price = webForm.itemPrice();
        webForm.addToBasket();
        Thread.sleep(2000);
        driver.get("https://www.gittigidiyor.com/sepetim");
        String priceBasket = webForm.basketPrice();

        if(price.equals(priceBasket)){
            System.out.println("Your prices are same " + price);
        }else {
            System.out.println("Your prices are different!!!");
        }

    }

    public static void addOneItem() throws InterruptedException {

        String test = "Ürün Toplamı (2 Adet)";
        Thread.sleep(1000);
        WebForm webForm = new WebForm(driver);
        webForm.addOneItem();
        Thread.sleep(1000);
        String itemCount = webForm.getItems();
        if (itemCount.equals(test)){
            System.out.println("You have 2 item that is true");
        }else {
            System.out.println("The is a mistake you don't have 2 items!!!");
        }
        Thread.sleep(1000);

    }

    public static void deleteBasket() throws InterruptedException {

        String empty = "Sepetinizde ürün bulunmamaktadır.";
        Thread.sleep(1000);
        WebForm webForm = new WebForm(driver);
        webForm.deleteBasket();
        Thread.sleep(2000);
        String emptyTest = webForm.emptyTest();

        if (empty.equals(emptyTest)) {
            System.out.println("There is no items in your basket.");
        } else {
            System.out.println("Your basket is not empty.");
        }

        Thread.sleep(2000);
        
    }

    @AfterSuite                        //After test here is in process
    public static void cleanUp() {
        driver.manage().deleteAllCookies();
        driver.close();
    }
}